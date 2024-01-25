import React, { useContext } from 'react'
import { LoginContext } from '../contexts/LoginContextProvider'
import Header from '../layout/Header'
import Footer from '../layout/Footer'

const Index = () => {

    const {isLogin, logout, userInfo} =useContext(LoginContext);

    return (
        <>
            <Header />
            
            <Footer />
        </>
    )
}

export default Index