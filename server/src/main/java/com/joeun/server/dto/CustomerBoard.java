package com.joeun.server.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerBoard {
    private int boardNo;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
}