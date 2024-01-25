import React, {useContext} from 'react'
import Header from '../layout/Header'
import JoinForm from '../components/Join/JoinForm'
import * as auth from '../apis/users/userAuthApi'
import {LoginContext} from '../contexts/LoginContextProvider'
import {useNavigate} from 'react-router-dom'
import Footer from '../layout/Footer'

const Join = () => {
    const {login} = useContext(LoginContext);
    const navigate = useNavigate();

    // 회원가입 요청
    const join = async (form) => {
        console.log(form);

        let response
        let data
        try {
            response =await auth.join(form)
        } catch (error) {
            console.error(`${error}`);
            console.error(`회원가입 요청 중 에러가 발생하였습니다.`);
            return
        }

        data = response.data;
        const status = response.status;
        console.log(`data : ${data}`);
        console.log(`status : ${status}`);

        if(status == 200) {
            console.log(`회원가입 성공!!!`);
            alert('회원가입 성공', '메인화면으로 이동합니다.', 'success', () => {navigate('/login')})
        } else {
            console.log(`회원가입 실해!`);
            alert('회원가입 실패', '회원가입에 실패하였습니다.', 'error')
        }
    }

    return (
        <>
            <Header />
            <div className='container' >
                <JoinForm join={join} />
            </div>
            <Footer />
        </>
    )
}

export default Join