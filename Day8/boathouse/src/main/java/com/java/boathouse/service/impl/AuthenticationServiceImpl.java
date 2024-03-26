package com.java.boathouse.service.impl;

import static com.java.boathouse.enumerated.TokenType.BEARER;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.boathouse.dto.request.ForgotPasswordRequest;
import com.java.boathouse.dto.request.LoginRequest;
import com.java.boathouse.dto.request.RegisterRequest;
import com.java.boathouse.dto.response.BasicResponse;
import com.java.boathouse.dto.response.LoginResponse;
import com.java.boathouse.model.Token;
import com.java.boathouse.model.User;
import com.java.boathouse.repository.TokenRepository;
import com.java.boathouse.repository.UserRepository;
import com.java.boathouse.service.AuthenticationService;
import com.java.boathouse.utils.JwtUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final TokenRepository tokenRepository;

    @Override
    public BasicResponse<String> register(RegisterRequest registerRequest) {
        Optional<User> isUserExists = userRepository.findByEmail(registerRequest.getEmail());
        if(isUserExists.isPresent()) {
            return BasicResponse.<String>builder().message("User already exists with email id"+ registerRequest.getEmail()).data("").build();

        }
        var user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword())).build();
        userRepository.save(user);
        return BasicResponse.<String>builder().message("User resgistered successfully").data("").build();
        
    }

    @Override
    public BasicResponse<LoginResponse> login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        var user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole().toString());
        var accessToken = jwtUtils.generateToken(claims, user);
        revokeAllUserToken(user);
        saveUserToken(accessToken, user);
        return BasicResponse.<LoginResponse>builder()
                            .message("User logged in successfully.")
                            .data(LoginResponse.builder().accessToken(accessToken).build())
                            .build();

    }

    private void saveUserToken(String accessToken, User user) {
        var token = Token.builder().token(accessToken).tokenType(BEARER).user(user).expired(false).revoked(false).build();
        tokenRepository.save(token);
    }


    private void revokeAllUserToken(User user) {
        var validUserTokens = tokenRepository.findAllByUser_IdAndRevokedFalseAndExpiredFalse(user.getId());
        if(validUserTokens.isEmpty()) {
            return;
        }
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    @Override
    public BasicResponse<String> forgotPassword(ForgotPasswordRequest forgotPasswordRequest) {
        var user = userRepository.findByEmail(forgotPasswordRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if(passwordEncoder.matches(forgotPasswordRequest.getCurrentPassword(), user.getPassword())) {
            return BasicResponse.<String>builder().message("Wrong password").data("").build();
        }
        if(forgotPasswordRequest.getNewPassword().equals(forgotPasswordRequest.getConfirmPassword())){
            return BasicResponse.<String>builder().message("Password mismatch").data("").build();

        }
        user.setPassword(passwordEncoder.encode(forgotPasswordRequest.getNewPassword()));
        userRepository.save(user);
        return BasicResponse.<String>builder().message("Password updated successfully.").data("").build();
    }

    
}
