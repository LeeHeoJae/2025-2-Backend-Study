package com.example.demo.member.dto;


import lombok.Getter;

// pwd, phoneNumber, address
@Getter
public class MemberUpdateRequest {
    private String pwd;
    private String phoneNumber;
    private String address;

    public MemberUpdateRequest(String pwd, String phoneNumber, String address) {
        this.pwd = pwd;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
