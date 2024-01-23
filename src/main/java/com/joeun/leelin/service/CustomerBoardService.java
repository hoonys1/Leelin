package com.joeun.leelin.service;

import java.util.List;

import com.joeun.leelin.dto.CustomerBoard;

public interface CustomerBoardService {
    // 게시글 목록
    public List<CustomerBoard> list() throws Exception;
    // 게시글 조회
    public CustomerBoard selectCB(int boardNo) throws Exception;
    // 게시글 등록
    public int insertCB(CustomerBoard customerBoard) throws Exception;
    // 게시글 수정
    public int updateCB(CustomerBoard customerBoard) throws Exception;
    // 게시글 삭제
    public int deleteCB(int boardNo) throws Exception;
    // 게시글 답변(나중에하자)
}
