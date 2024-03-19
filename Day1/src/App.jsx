import React, { lazy } from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import LazySuspense from './component/LazySuspense';
const LazyUserLogin = lazy(() => import("./pages/user/UserLogin"));
const LazyAdminLogin = lazy(() => import("./pages/admin/AdminLogin"));
const LazyRegistration = lazy(() => import("./pages/user/Registration"));
const LazySignup = lazy(() => import("./pages/auth/Signup"));
const LazyUserLayout = lazy(() => import("./pages/user/UserLayout"));
const LazyHome = lazy(() => import("./pages/user/Home"));
const LazyAdminLayout = lazy(() => import("./pages/admin/AdminLayout"));
const LazyUserDashboard = lazy(()=>import("./pages/user/UserDashboard"));
const LazyRole= lazy(()=>import("./pages/user/Role"));
// const LazyNavbar= lazy(()=>import("./component/Header/Navbar"));
// const LazyFooter= lazy(()=>import("./component/Footer/Footer"));
const LazyAbout= lazy(()=>import("./pages/user/About"));
const LazyViewboat= lazy(()=>import("./pages/user/Viewboat"));
const LazyUserprofile= lazy(()=>import("./pages/user/Userprofile"));
const LazyMybookings= lazy(()=>import("./pages/user/Mybookings"));
const LazyBookings= lazy(()=>import("./pages/user/Booking"));
const LazyContact= lazy(()=>import("./pages/user/Contact"));
const LazyAdmindashboard= lazy(()=>import("./pages/admin/Admindashboard"));
const LazyUserdetails= lazy(()=>import("./pages/admin/Userdetails"));
const LazyAddboat= lazy(()=>import("./pages/admin/Addboat"));
const LazyVieweditboat= lazy(()=>import("./pages/admin/Vieweditboat"));
import './assets/css/App.css'
import Home from './pages/user/Home';
import AdminLogin from './pages/admin/AdminLogin';
import UserLogin from './pages/user/UserLogin';
import UserDashboard from './pages/user/UserDashboard';
import Registration from './pages/user/Registration';
import Mybookings from './pages/user/Mybookings';
import Bookings from './pages/user/Booking';
import Admindashboard from './pages/admin/Admindashboard';
import Vieweditboat from './pages/admin/Vieweditboat';
import Addboat from './pages/admin/Addboat';
import Viewboat from './pages/user/Viewboat';
import About from './pages/user/About';
import Contact from './pages/user/Contact';
import Role from './pages/user/Role';
import Userprofile from './pages/user/Userprofile';
import Userdetails from './pages/admin/Userdetails';
import forgotpassword from './pages/user/forgotpassword';
import privacy from './pages/user/Privacy';

// import Navbar from './component/Header/Navbar';

const UserRoutes =()=> {
  return(
  <LazyUserLayout>
    <Routes>
      <Route path='/userlogin' element={<LazySuspense component={UserLogin}/>}/>
     <Route path="/Registration" element={<LazySuspense component ={Registration} />} />
    <Route path="/Role" element={<LazySuspense component ={Role} />} /> 
    <Route path="/about" element={<LazySuspense component ={About} />} />
    <Route path="/contact" element={<LazySuspense component ={Contact} />} />
    <Route path="/forgot" element={<LazySuspense component ={forgotpassword} />} />
    <Route path="/privacy" element={<LazySuspense component ={privacy} />} />
    </Routes>
  </LazyUserLayout>
)
  }

const AdminRoutes =()=> {
  return(
  <LazyAdminLayout>
    <Routes>
    <Route path='/adminlogin' element={<LazySuspense component={AdminLogin}/>}/>
<Route path="/forgot" element={<LazySuspense component ={forgotpassword} />} />
{/* <Route path="/about" element={<LazySuspense component ={About} />} /> */}

    </Routes>
  </LazyAdminLayout>
)
}

function App() {
  return ( 
    <Routes> 
        {/* <Navbar/> */}
        
<Route path="/" element={<Navigate to="/home" />} />
<Route path="/home" element={<LazySuspense component ={Home} />} />
        <Route path="/user/*" element={<LazySuspense component ={UserRoutes} />} />
<Route path='/userdashboard' element={<LazySuspense component={UserDashboard}/>}/>
<Route path="/viewboat" element={<LazySuspense component ={Viewboat} />} />
<Route path="/userprofile" element={<LazySuspense component ={Userprofile} />} />
<Route path="/mybooking" element={<LazySuspense component ={Mybookings} />} />
<Route path="/booking" element={<LazySuspense component ={Bookings} />} />
        <Route path = "/admin/*" element={<LazySuspense component ={AdminRoutes} />} />
<Route path="/admindashboard" element={<LazySuspense component ={Admindashboard} />} />
<Route path="/userdetails" element={<LazySuspense component ={Userdetails} />} />

<Route path="/addboat" element={<LazySuspense component ={Addboat} />} />
<Route path="/vieweditboat" element={<LazySuspense component ={Vieweditboat} />} />
        {/* <Route path = "*" element={<LazySuspense component ={Unauthorized} />} /> */}
      </Routes>
  );
}

export default App;