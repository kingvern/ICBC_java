package com.icbc.common.lang.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class CancelCardIIDto implements Serializable {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String idCard;

    @NotBlank(message = "密码不能为空")
    private String card_II_ID;

    @NotBlank(message = "密码不能为空")
    private String paymentPassword;

    @NotBlank(message = "密码不能为空")
    private String phoneNumber;

    @NotBlank(message = "密码不能为空")
    private String captchaCode;


}
