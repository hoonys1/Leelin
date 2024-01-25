package com.joeun.server.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joeun.server.dto.CustomerBoard;
import com.joeun.server.service.CustomerBoardService;

/**
 * 게시판 컨트롤러
 * - 게시글 목록            - [GET] - /customerBoard/list
 * - 게시글 조회            - [GET] - /customerBoard/read
 * - 게시글 등록            - [GET] - /customerBoard/insert
 * - 게시글 등록 처리        - [POST] - /customerBoard/insert
 * - 게시글 수정            - [GET] - /customerBoard/update
 * - 게시글 수정 처리        - [POST] - /customerBoard/update
 * - 게시글 삭제 처리        - [POST] - /customerBoard/delete
 */
@Slf4j          // 로그 사용 어노테이션
@Controller
@RequestMapping("/customerBoard")
public class CustomerBoardController {
    
    @Autowired
    private CustomerBoardService customerBoardService;

    /**
     * 게시글 조회
     * [GET]
     * /customerBoard
     * model : boardList
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping(value="/")
    public String list(Model model) throws Exception {
        log.info("[GET] 고객센터 리스트 출력");
        // 데이터 요청
        List<CustomerBoard> bouardList = customerBoardService.list();
        // 모델 등록
        model.addAttribute("boardList", bouardList);
        // 뷰 페이지 지정
        return "customerBoard/";
    }

    /**
     * 게시글 쓰기
     * [GET]
     * /customerBoard/insert
     * model : ❌
     * @param customerBoard
     * @return
     */
    @GetMapping("/insert")
    public String insert(@ModelAttribute CustomerBoard customerBoard) {
        log.info("게시글 쓰기");
        return "customerBoard/insert";
    }

    /**
     * 게시글 쓰기 처리
     * [POST]
     * /customerBoard/insert
     * model : ❌
     * @param customerBoard
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/insert")
    public String insertPro(@ModelAttribute CustomerBoard customerBoard) throws Exception {
        // @ModelAttribute : 모델에 자동으로 등록해주는 어노테이션
        // 데이터 처리
        int result = customerBoardService.insertCB(customerBoard);

        log.info("게시글 쓰기 처리");

        // 게시글 쓰기 실패 ➡️ 게시글 쓰기 화면
        if(result == 0) return "customerBoard/insert";

        // 뷰 페이징 지정
        return "redirect:/customerBoard/";
    }

    /**
     * 게시글 수정
     * [GET]
     * /customerBoard/update
     * model : board
     * @param model
     * @param boardNo
     * @return
     * @throws Exception
     */
    @GetMapping(value="/update")
    public String update(Model model, int boardNo) throws Exception {
        // 데이터 요청
        CustomerBoard board = customerBoardService.selectCB(boardNo);
        // 모델 등록
        model.addAttribute("board", board);

        log.info("게시글 수정");
        // 뷰 페이지 지정
        return "customerBoard/update";
    }

    /**
     * 게시글 수정 처리
     * [POST]
     * /customerBoard/update
     * model : board
     * @param customerBoard
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/update")
    public String updatePro(CustomerBoard customerBoard) throws Exception {
        // 데이터 처리
        int result = customerBoardService.updateCB(customerBoard);
        int boardNo = customerBoard.getBoardNo();

        // 게시글 수정 실패 ➡️ 게시글 수정 화면
        if(result == 0) return "redirect:/customerBoard/update?boardNo=" + boardNo;

        log.info("게시글 수정 처리");

        // 뷰 페이지 지정
        return "redirect:/customerBoard/";
    }

    @DeleteMapping(value = "/delete")
    public String deletePro(int boardNo) throws Exception {
        // 데이터 처리
        int result = customerBoardService.deleteCB(boardNo);

        // 게시글 삭제 실패 ➡ 게시글 수정  화면
        if(result == 0) return "redirect:/customerBoard/update?boardNo=" + boardNo;

        log.info("게시글 삭제");

        // 뷰 페이지 지정
        return "redirect:/customerBoard/";
    }
}
