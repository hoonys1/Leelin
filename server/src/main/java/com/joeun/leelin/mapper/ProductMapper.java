package com.joeun.leelin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.leelin.dto.Product;

@Mapper
public interface ProductMapper {
    // 게시글 목록
    public List<Product> list() throws Exception;
    // 게시글 조회
    public Product selectP(int productNo) throws Exception;
    // 게시글 등록
    public int insertP(Product product) throws Exception;
    // 게시글 수정
    public int updateP(Product product) throws Exception;
    // 게시글 삭제
    public int deleteP(int productNo) throws Exception;
}
