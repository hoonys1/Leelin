import Cookies from 'js-cookie';
import React, {useContext, useEffect, useState} from 'react';
import { LoginContext } from '../../contexts/LoginContextProvider';
import {Link} from 'react-router-dom';

const LoginFomr = () => {
    const {login} = useContext(LoginContext);
    const [rememberUserId, setRememberUserId] = useState();

    const onLogin = (e) => {
        e.preventDefault()
        const username = e.target.username.value;
        const password = e.target.password.value;
        const rememberId = e.target.rememberId.checked;
        // const rememberMe = e.target.rememberMe.checked;
        console.log(e.target.username.value);
        console.log(e.target.password.value);
        console.log(e.target.rememberId.checked);
        // console.log(e.target.rememberMe.checked);

        login(username, password, rememberId);
        // login(userId, userPw, rememberId, rememberMe);
    }

    useEffect( () => {
        // 쿠키에서 저장된 아이디 가져오기
        const remeberId = Cookies.get('rememberId');
        console.log(`쿠키 remeberId : ${remeberId}`);
        setRememberUserId(remeberId)
    }, [])

    return (
        <div className='form'>
            <h2 className='lgoin-title'>Login</h2>

            <form className='login-form' onSubmit={(e) => onLogin(e)}>
                <div>
                    <label htmlFor='name'>Id</label>
                    <input
                        id='username'
                        type='text'
                        placeholder='Id'
                        name='username'
                        autoComplete='username'
                        required
                        defaultValue={rememberUserId}
                    />
                </div>
                <div>
                    <label htmlFor='password'>password</label>
                    <input
                        id='password'
                        type='password'
                        placeholder='password'
                        name='password'
                        autoComplete='current-password'
                        required
                    />
                </div>
                <div className='form-check'>
                    <label className='toggle-btn'>
                        {!rememberUserId
                            ?
                            <input type='checkbox' id='remember-Id' name='rememberId' value='0' />
                            :
                            <input type='checkbox' id='remember-Id' name='rememberId' value='0' defaultChecked />
                        }
                        <span className='slider'></span>
                    </label>
                    <label htmlFor='remember-id' className='check-label'>아이디 저장</label>
                </div>
                <button className='btn btn-form btn-login' value='Login'>
                    로그인
                </button>
            </form>
            <button className='btn btn-join'>
                <Link to='/join'>회원가입</Link>
            </button>
        </div>
    )
}

export default LoginFomr