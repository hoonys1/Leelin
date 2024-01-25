import React, { useContext } from "react";
import { LoginContext } from "../contexts/LoginContextProvider";
import {Link} from 'react-router-dom';
import './Header.css';

const Header = () => {
    const {isLogin, logout, userInfo} = useContext(LoginContext);
    return (
        <header className="header">
            <div className="logo">
                <Link to='/'>
                    <img src='' alt='logo' className="logo" />
                </Link>
            </div>
            <div className="util">
                <ul>
                    {/* 로그인 여부에 따라 조건부 랜더링 */}
                    { !isLogin ?
                        <>
                            <li><Link to='/login'>로그인</Link></li>
                            <li><Link to='/join'>회원가입</Link></li>
                        </>
                    :
                        <>    
                            <li><Link to='/user'>장바구니</Link></li>
                            <li><Link to='/login'>주문조회</Link></li>
                            <li><Link to='/login'>마이페이지</Link></li>
                            <li><button className="link" onClick={() => logout()}>로그아웃</button></li>
                        </>
                    }
                </ul>
            </div>
        </header>
    );
}

export default Header