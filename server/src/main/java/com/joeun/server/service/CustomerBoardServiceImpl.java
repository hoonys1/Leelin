package com.joeun.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.server.dto.CustomerBoard;
import com.joeun.server.mapper.CustomerBoardMapper;

@Service
public class CustomerBoardServiceImpl implements CustomerBoardService{

    @Autowired
    private CustomerBoardMapper customerBoardMapper;

    // 게시글 목록
    @Override
    public List<CustomerBoard> list() throws Exception {
        List<CustomerBoard> boardList = customerBoardMapper.list();
        return boardList;
    }

    // 게시글 조회
    @Override
    public CustomerBoard selectCB(int boardNo) throws Exception {
        CustomerBoard board = customerBoardMapper.selectCB(boardNo);
        return board;
    }

    // 게시글 등록
    @Override
    public int insertCB(CustomerBoard customerBoard) throws Exception {
        int result = customerBoardMapper.insertCB(customerBoard);
        return result;
    }

    // 게시글 수정
    @Override
    public int updateCB(CustomerBoard customerBoard) throws Exception {
        int result = customerBoardMapper.updateCB(customerBoard);
        return result;
    }

    // 게시글 삭제
    @Override
    public int deleteCB(int boardNo) throws Exception {
        int result = customerBoardMapper.deleteCB(boardNo);
        return result;
    }

   
    
}
