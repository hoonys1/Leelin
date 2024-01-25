import React, {useEffect, useState} from "react";
import * as customerBoard from '../apis/customerBoard/customerBoardApi';
import CustomerBoardList from '../components/CustomerBoard/CustomerBoardList/CustomerBoardList';
// import 
// import 

// 게시글 목록
const CustomerBoardContainer = () => {

    // state 설정
    const [customerBoardList, setCustomerBoardList] = useState([]);

    // 게시글 목록 데이터
    const getboardList = async () => {
        const response = await customerBoard.list();
        const data = await response.data;
        console.log(data);
        setCustomerBoardList(data);
    };

    useEffect( () => {
        getboardList();
    }, []);

    return <CustomerBoardList customerBoardList={customerBoardList} />
}
export default CustomerBoardContainer
