import axios from 'axios';

// 고객 게시판 목록
export const list = () => axios.get('/customerBoard');
// 고객 게시판 조회
export const select = (no) => axios.get(`customerBoard/${no}`);
// 고객 게시판 등록
export const insert = (title, writer, content) => axios.post('customerBoard', {title, writer, content});
// 고객 게시판 수정
export const update = (no, title, content) => axios.put('customerBoard', {no, title, content});
// 고객 게시판 삭제
export const remove = (no) => axios.delete(`/customerBoard/${no}`);