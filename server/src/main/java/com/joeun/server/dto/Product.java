package com.joeun.server.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Product {
    private int productNo;
    private String productName;
    private String category;
    private String color;
    private String size;
    private int price;
    private String description;
    private Date reg_date;
    private Date upd_date;
}
