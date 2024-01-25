import React from "react"
import Header from "../layout/Header"
import Footer from "../layout/Footer"
import LoginFomr from "../components/Login/LoginForm"

const Login = () => {
    return (
        <>
            <Header />
            <div className='container'>
                <LoginFomr />
            </div>
            <Footer />
        </>
    )
}
export default Login