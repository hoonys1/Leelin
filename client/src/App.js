import React from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import Index from './pages/Index';
import Login from './pages/Login';
import Join from './pages/Join';
import CustomerBoard from './containers/CustomerBoardContainer'
import LoginContextProvider from './contexts/LoginContextProvider'
// import 
import './App.css';

function App() {
  return (
    <BrowserRouter>
      <LoginContextProvider>
        <Routes>
          <Route path='/' element={<Index />} />
          <Route path='/login' element={<Login />} />
          <Route path='/join' element={<Join />} />
          <Route path='/Customer' element={<CustomerBoard />} />
          <Route path='/Customer/:no' element={<CustomerBoard />} />
          <Route path='/Customer/insert' element={<CustomerBoard />} />
          <Route path='/Customer/update/:no' element={<CustomerBoard />} />
        </Routes>
      </LoginContextProvider>
    </BrowserRouter>
  );
}

export default App;