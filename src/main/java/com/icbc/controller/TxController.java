package com.icbc.controller;


import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.icbc.common.lang.Result;
import com.icbc.common.lang.dto.TxDto;
import com.icbc.entity.Card;
import com.icbc.service.CardService;
import com.icbc.util.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kingvern
 * @since 2020-08-19
 */
@RestController
public class TxController {

    @Autowired
    CardService cardService;

    @RequiresAuthentication
    @PostMapping("/recharge")
    public Result recharge(@Validated @RequestBody TxDto txDto) {
        Integer user_id = ShiroUtil.getProfile().getId();
        Card card_I = cardService.getOne(new QueryWrapper<Card>().eq("card_id", txDto.getCard_I_ID()));
        Card card_II = cardService.getOne(new QueryWrapper<Card>().eq("card_id", txDto.getCard_II_ID()));
        Assert.isTrue((user_id == card_I.getUserId()) && (user_id == card_II.getUserId()), "不是你的卡呀");

        Double amount = Double.parseDouble(txDto.getAmount());
        if (amount > card_I.getBalance()) {
            return Result.fail("余额不足");
        }
        if(!card_I.getPaymentPassword().equals(txDto.getPaymentPassword())){
            return Result.fail("密码不正确");
        }
        card_I.setBalance(card_I.getBalance() - amount);
        card_II.setBalance(card_II.getBalance() + amount);
        cardService.saveOrUpdate(card_I);
        cardService.saveOrUpdate(card_II);
        return Result.succ(MapUtil.builder()
                .put("card_I", card_I)
                .put("card_II", card_II)
                .map());
    }

    @RequiresAuthentication
    @PostMapping("/withdraw")
    public Result withdraw(@Validated @RequestBody TxDto txDto) {
        Integer user_id = ShiroUtil.getProfile().getId();
        Card card_I = cardService.getOne(new QueryWrapper<Card>().eq("card_id", txDto.getCard_I_ID()));
        Card card_II = cardService.getOne(new QueryWrapper<Card>().eq("card_id", txDto.getCard_II_ID()));
        Assert.isTrue((user_id == card_I.getUserId()) && (user_id == card_II.getUserId()), "不是你的卡呀");

        Double amount = Double.parseDouble(txDto.getAmount());
        if (amount > card_II.getBalance()) {
            return Result.fail("余额不足");
        }
        if(!card_II.getPaymentPassword().equals(txDto.getPaymentPassword())){
            return Result.fail("密码不正确");
        }
        card_I.setBalance(card_I.getBalance() + amount);
        card_II.setBalance(card_II.getBalance() - amount);
        cardService.saveOrUpdate(card_I);
        cardService.saveOrUpdate(card_II);
        return Result.succ(MapUtil.builder()
                .put("card_I", card_I)
                .put("card_II", card_II)
                .map());
    }

}
