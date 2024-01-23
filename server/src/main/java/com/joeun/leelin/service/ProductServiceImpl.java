package com.joeun.leelin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.leelin.dto.Product;
import com.joeun.leelin.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    // 게시글 목록
    @Override
    public List<Product> list() throws Exception {
        List<Product> productList = productMapper.list();
        return productList;
    }

    // 게시글 조회
    @Override
    public Product selectP(int productNo) throws Exception {
        Product product = productMapper.selectP(productNo);
        return product;
    }

    // 게시글 등록
    @Override
    public int insertP(Product product) throws Exception {
        int result = productMapper.insertP(product);
        return result;
    }

    // 게시글 수정
    @Override
    public int updateP(Product product) throws Exception {
        int result = productMapper.updateP(product);
        return result;
    }

    // 게시글 삭제
    @Override
    public int deleteP(int productNo) throws Exception {
        int result = productMapper.deleteP(productNo);
        return result;
    }
    
}
