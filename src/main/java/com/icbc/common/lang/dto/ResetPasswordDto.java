package com.icbc.common.lang.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class ResetPasswordDto implements Serializable {

//    @NotBlank(message = "用户名不能为空")
    private String username;

//    @NotBlank(message = "idDard不能为空")
    private String idCard;

//    @NotBlank(message = "phoneNumber不能为空")
    private String phoneNumber;

//    @NotBlank(message = "captchaCode不能为空")
    private String captchaCode;

//    @NotBlank(message = "新密码不能为空")
    private String loginPassword;

//    @NotBlank(message = "确认新密码不能为空")
    private String loginPasswordConfirm;

}
