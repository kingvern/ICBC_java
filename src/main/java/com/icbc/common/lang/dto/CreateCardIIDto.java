package com.icbc.common.lang.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class CreateCardIIDto implements Serializable {

    @NotBlank(message = "username不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String idCard;

    @NotBlank(message = "密码不能为空")
    private String gender;

    @NotBlank(message = "密码不能为空")
    private String job;

    @NotBlank(message = "密码不能为空")
    private String familyAddress;

    @NotBlank(message = "密码不能为空")
    private String masterCardOpeningBank;

    @NotBlank(message = "密码不能为空")
    private String masterCardID;

    @NotBlank(message = "密码不能为空")
    private String phoneNumber;

    @NotBlank(message = "密码不能为空")
    private String captchaCode;

    @NotBlank(message = "密码不能为空")
    private String paymentPassword;

    @NotBlank(message = "密码不能为空")
    private String paymentPasswordConfirm;




}
