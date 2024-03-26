package com.java.boathouse.service;

import com.java.boathouse.dto.request.ForgotPasswordRequest;
import com.java.boathouse.dto.request.LoginRequest;
import com.java.boathouse.dto.request.RegisterRequest;
import com.java.boathouse.dto.response.BasicResponse;
import com.java.boathouse.dto.response.LoginResponse;

public interface AuthenticationService {
    BasicResponse <String> register ( RegisterRequest registerRequest);

    BasicResponse <LoginResponse> login (LoginRequest loginRequest);

    BasicResponse<String> forgotPassword(ForgotPasswordRequest forgotPasswordRequest);

}
