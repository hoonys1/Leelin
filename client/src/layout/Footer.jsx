import React, {Component} from 'react';

class Footer extends Component {
    render() {
        return (
            <footer className='footer'>
                <li className='callcenter'>
                    <span style={{fontSize: '20px', fontWeight: 'bold'}}> 고객센터 : TEL 1670-7630 </span>
                </li>
                <li></li>
                <li>
                    <span style={{fontSize: '13px', fontWeight: 'bold'}}>평일: 오전 10시~ 오후5시</span>
                </li>
                <li>
                    <span style={{fontSize: '13px', fontWeight: 'bold'}}>점심시간: 12시~1시 (토/일/공휴일 휴무)</span>
                </li>
                <li>서울특별시 중구 청구로4길 19, 3층(신당동, 정선빌딩)</li>
                <li>상호명 : 주식회사 엘오에이&nbsp;&nbsp;대표 : 이승오</li>
                <li>TEL : 1670-7630&nbsp;&nbsp;사업자번호 :  201-86-09457</li>
                <li></li>
                <li>본(리린)쇼핑몰의 사진과 저작권과 초상권은 리린에 있으며,</li>
                <li>무단 컨텐츠도용시 법적처벌및 손해배상을 청구할 수 있습니다.</li>
            </footer>
        );
    }
}

export default Footer