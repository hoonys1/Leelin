package com.joeun.server.dto;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Users {
    private int userNo;
    private String userId;
    private String userPw;
    private String userPwCheck;     // 비밀번호 확인
    private String name;
    private int phone;
    private String email;
    private String adress;
    private Date regDate;
    private Date updDate;
    // private int enabled;            // 휴면여부

    // 권한 목록
    List<UserAuth> authList;

    public Users() {

    }

    public Users(Users user) {
        this.userNo = user.getUserNo();
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();
        this.userPwCheck = user.getUserPwCheck();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.adress = user.getAdress();
        this.regDate = user.getRegDate();
        this.updDate = user.getUpdDate();
        this.authList = user.getAuthList();
    }

}
