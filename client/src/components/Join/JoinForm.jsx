import React, {useContext} from 'react';
import { LoginContext } from '../../contexts/LoginContextProvider'

const JoinForm = ({join}) => {
    const {login} = useContext(LoginContext);

    const onJoin = (e) => {
        e.proventDefault();
        const userId = e.target.username.value;
        const userPw = e.target.password.value;
        const userPwCheck = e.target.userPwCheck.value;
        const name = e.target.name.value;
        const phone = e.target.phone.value;
        const email = e.target.email.value;
        const adress = e.target.adress.value;

        console.log(userId, userPw, userPwCheck, name, phone, email, adress);

        join({userId, userPw, userPwCheck, name, phone, email, adress})
    };

    return (
        <div className='form'>
            <h2 className='login-title'>Join</h2>

            <form className='login-form' onSubmit={(e) => onJoin(e)}>
                <div>
                    <label htmlFor='username'>ID</label>
                    <input
                        id='username'
                        type='text'
                        placeholder='username'
                        name='username'
                        autoComplete='username'
                        required
                    />
                    <label htmlFor='password'>Password</label>
                    <input
                        id='password'
                        type='password'
                        placeholder='password'
                        name='password'
                        autoComplete='password'
                        required
                    />
                    <label htmlFor='userPwCheck'>PWCheck</label>
                    <input
                        id='userPwCheck'
                        type='password'
                        placeholder='userPwCheck'
                        name='userPwCheck'
                        autoComplete='userPwCheck'
                        required
                    />
                    <label htmlFor='name'>이름</label>
                    <input
                        id='name'
                        type='text'
                        placeholder='이름'
                        name='name'
                        autoComplete='name'
                        required
                    />
                    <label htmlFor='phone'>연락처</label>
                    <input
                        id='phone'
                        type='text'
                        placeholder='-생략하고 연락처'
                        name='phone'
                        autoComplete='phone'
                        required
                    />
                    <label htmlFor='email'>E-Mail</label>
                    <input
                        id='email'
                        type='text'
                        placeholder='email'
                        name='email'
                        autoComplete='email'
                        required
                    />
                    <label htmlFor='adress'>주소</label>
                    <input
                        id='adress'
                        type='text'
                        placeholder='주소'
                        name='adress'
                        autoComplete='adress'
                        required
                    />
                </div>
                <button className='btn btn-form btn-login' type='submint'>
                    가입하기
                </button>
            </form>
        </div>
    )
}

export default JoinForm