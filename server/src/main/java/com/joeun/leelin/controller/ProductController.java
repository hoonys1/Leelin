package com.joeun.leelin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joeun.leelin.dto.Files;
import com.joeun.leelin.dto.Product;
import com.joeun.leelin.service.FileService;
import com.joeun.leelin.service.ProductService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Slf4j
@Controller
@RequestMapping("/Product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @Autowired
    private FileService fileService;

    /**
     * 상품목록 조회
     * [GET]
     * /product/
     * model : productList
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping(value="/")
    public String list(Model model, int productNo, Files files) throws Exception {
        log.info("[GET] 제품 리스트 출력");
        // 데이터 요청
        List<Product> productList = productService.list();  // 게시글 정보

        files.setParentTable("product");
        files.setParentNo(productNo);
        List<Files> filesList = fileService.listByParent(files);    // 파일 정보
        // 모델 등록
        model.addAttribute("productList", productList);
        model.addAttribute("fileList", filesList);
        // 뷰 페이지 지정
        return "product/";
    }
    
    /**
     * 게시글 쓰기
     * [GET]
     * /product/insert
     * model : ❌
     * @param produt
     * @return
     */
    @GetMapping("/insert")
    public String insert(@ModelAttribute Product produt) {
        log.info("상품 등록");
        return "product/insert";
    }

    /**
     * 게시글 쓰기 처리
     * [POST]
     * /product/insert
     * model : ❌
     * @param product
     * @return
     * @throws Exception
     */
    @PostMapping("/insert")
    public String insertPro(@ModelAttribute Product product) throws Exception {
        // @ModelAttribute : 모델에 자동으로 등록해주는 어노테이션
        // 데이터 처리
        int result = productService.insertP(product);

        log.info("상품등록 처리");

        // 상품등록 실패 ➡️ 게시글 쓰기 화면
        if(result == 0) return "product/insert";

        // 뷰 페이징 지정
        return "redirect:/product/";
    }
    
    /**
     * 상품 수정
     * [GET]
     * /product/update
     * model : product
     * @param model
     * @param productNo
     * @return
     * @throws Exception
     */
    @GetMapping(value="/update")
    public String update(Model model, int productNo) throws Exception {
        // 데이터 요청
        Product product = productService.selectP(productNo);
        // 모델 등록
        model.addAttribute("product", product);

        log.info("상품 수정");
        // 뷰 페이지 지정
        return "product/update";
    }

    @PostMapping(value="/update")
    public String updatePro(Product product) throws Exception {
        // 데이터 처리
        int result = productService.updateP(product);
        int productNo = product.getProductNo();

        // 상품수정 실패 ➡️ 게시글 수정 화면
        if(result == 0) return "redirect:/product/update?productNo";

        log.info("상품수정 처리");

        // 뷰 페이지 지정
        return "redirect:/product/";
    }
    

}
