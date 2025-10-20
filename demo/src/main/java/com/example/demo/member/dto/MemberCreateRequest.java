package com.example.demo.member.dto;

import lombok.Getter;

// loginId, pwd, phoneNumber, address
@Getter
public class MemberCreateRequest {

    private String loginId;
    private String pwd;
    private String phoneNumber;
    private String address;

    public MemberCreateRequest(String loginId, String pwd, String phoneNumber, String address) {
        this.loginId = loginId;
        this.pwd = pwd;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
