import api from './api';
import { Cookies } from 'react-cookie'

const cookies = new Cookies();

// 로그인
export const login = (username, password) => api.post(`/login?username=${username}&password=${password}`)

// export const login = (username, password) => {
//     return api.post('/login', { username, password });
// }

// 사용자 정보
export const userInfo = () => {
    return api.get(`/users/info`)
}

// 회원가입
export const join = (data) => {
    return api.post(`/users`, data)
}
// export const join = (users) => {
//     return api.post(`/api/user`, users, {
//         headers: {
//             'Content-Type': 'multipart/form-data'
//         }j
//     })
// }

// 회원 정보 수정
export const update = (data) => {
    return api.put(`/users`, data)
}

// 회원탈퇴
export const remove = (userId) => api.delete(`/users/${userId}`)


// export const update = (users) => {
//     return api.put(`/api/user`, users, {
//         headers: {
//             'Content-Type': 'multipart/form-data'
//         }
//     })
// }

// 아이디 중복검사
// export const usernameCheck = (userId) => {
//     return api.get(`/api/user/getLoginIdDup?username=${userId}`)
// }

// 닉네임 중복검사
// export const nicknameCheck = (nickname) => {
//     return api.get(`/api/user/getNicknameDup?nickname=${nickname}`)
// }

// 핸드폰 중복검사
// export const phoneCheck = (phone) => {
//     return api.get(`/api/user/getPhoneDup?phone=${phone}`)
// }

// 쿠키
export const getCookieValue = (cookieName) => {
    return cookies.get(cookieName)
}
