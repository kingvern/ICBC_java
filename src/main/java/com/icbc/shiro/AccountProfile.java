package com.icbc.shiro;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountProfile implements Serializable {

    private Integer id;

    private String idCard;

    private String username;

    private String nickname;

    private String familyAddress;

    private String phoneNumber;

    private Integer job;

    private Integer gender;

}
