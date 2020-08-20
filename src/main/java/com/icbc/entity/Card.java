package com.icbc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kingvern
 * @since 2020-08-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

@TableName("card")
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String cardId;

    private String branchOfOpeningBank;

    private Integer userId;

    private String paymentPassword;

    private String masterCardId;

    private Double balance;

    private Integer level;

    private Integer alive;

    private LocalDateTime registerDate;

    private LocalDateTime cancelationDate;


}
