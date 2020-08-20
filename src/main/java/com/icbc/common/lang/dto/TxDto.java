package com.icbc.common.lang.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class TxDto implements Serializable {

    @NotBlank(message = "card_I_ID不能为空")
    private String card_I_ID;

    @NotBlank(message = "card_II_ID不能为空")
    private String card_II_ID;

    @NotBlank(message = "amount不能为空")
    private String amount;

    @NotBlank(message = "paymentPassword不能为空")
    private String paymentPassword;


}
