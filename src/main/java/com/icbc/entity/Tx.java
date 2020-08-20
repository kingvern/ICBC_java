package com.icbc.entity;

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
@TableName("tx")
public class Tx implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer txId;

    private String flowInCard;

    private String flowOutCard;

    private Double txAmount;

    private LocalDateTime registerDate;


}
