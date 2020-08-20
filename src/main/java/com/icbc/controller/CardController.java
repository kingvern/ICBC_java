package com.icbc.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.icbc.common.lang.Result;
import com.icbc.common.lang.dto.CancelCardIIDto;
import com.icbc.common.lang.dto.CreateCardIIDto;
import com.icbc.entity.Captcha;
import com.icbc.entity.Card;
import com.icbc.entity.User;
import com.icbc.service.CaptchaService;
import com.icbc.service.CardService;
import com.icbc.service.UserService;
import com.icbc.util.JwtUtils;
import com.icbc.util.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kingvern
 * @since 2020-08-19
 */
@RestController
public class CardController {

    @Autowired
    UserService userService;

    @Autowired
    CardService cardService;

    @Autowired
    CaptchaService captchaService;

    @Autowired
    JwtUtils jwtUtils;



    @PostMapping("/createAccount")
    public Result createAccount(@Validated @RequestBody CreateCardIIDto createCardIIDto, HttpServletResponse response) {
        User user = userService.getOne(new QueryWrapper<User>().eq("phone_number", createCardIIDto.getPhoneNumber()));
        Card card_I = cardService.getOne(new QueryWrapper<Card>().eq("user_id", user.getId()).eq("level", '1'));
        Card card_II = cardService.getOne(new QueryWrapper<Card>().eq("user_id", user.getId()).eq("level", '2'));
        Assert.notNull(card_I, "没有一类卡");
        Assert.isNull(card_II, "已有二类卡");
        Assert.isTrue(createCardIIDto.getPaymentPassword().equals(createCardIIDto.getPaymentPasswordConfirm()), "两次密码不同");
//        TODO：判断createCardIIDto字段
        Card temp = new Card();
        String card_I_ID = card_I.getCardId();
        String card_II_ID = card_I_ID.replace('1', '2');
        temp.setCardId(card_II_ID);
        temp.setMasterCardId(card_I_ID);
        temp.setUserId(user.getId());
        temp.setLevel(2);
        temp.setPaymentPassword(createCardIIDto.getPaymentPassword());
        temp.setBranchOfOpeningBank("中国工商银行(北京分行)");
        temp.setBalance(0.0);
        temp.setAlive(1);
        temp.setMasterCardId(card_I.getCardId());
        temp.setRegisterDate(LocalDateTime.now());

//        BeanUtil.copyProperties(createCardIIDto, temp, "id", "userId", "created", "status");

        cardService.save(temp);

        String jwt = jwtUtils.generateToken(user.getId());

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        return Result.succ(MapUtil.builder()
                .put("user", user)
                .put("card_I", card_I)
                .put("card_II", temp)
                .map()
        );

    }

    @RequiresAuthentication
    @PostMapping("/cancelAccount")
    public Result cancelAccount(@Validated @RequestBody CancelCardIIDto cancelCardIIDto) {
        Integer user_id = ShiroUtil.getProfile().getId();
        User user = userService.getById(user_id);
        Assert.isTrue(user.getUsername().equals(cancelCardIIDto.getUsername()) , "username");
        Assert.isTrue(user.getIdCard().equals(cancelCardIIDto.getIdCard()), "id_card");
        Assert.isTrue(user.getPhoneNumber().equals(cancelCardIIDto.getPhoneNumber()),  "username");

        Card card_II = cardService.getOne(new QueryWrapper<Card>().eq("user_id", user_id).eq("level", '2'));
        Assert.notNull(card_II, "此二类卡不存在");
        Assert.isTrue(card_II.getCardId().equals(cancelCardIIDto.getCard_II_ID()), "card_II_id");
        Assert.isTrue(card_II.getPaymentPassword().equals(cancelCardIIDto.getPaymentPassword()), "paymentpassword");


        System.out.println(cancelCardIIDto.getPhoneNumber() +" vs "+ cancelCardIIDto.getCaptchaCode());
//        Captcha captcha = captchaService.getOne(new QueryWrapper<Captcha>().eq("user_phone_number", cancelCardIIDto.getPhoneNumber()).eq("captcha_code", cancelCardIIDto.getCaptchaCode()).eq("behavior", -1));
//        Assert.notNull(captcha, "验证码有点问题");
        card_II.setAlive(-1);
        card_II.setCancelationDate(LocalDateTime.now());
        cardService.saveOrUpdate(card_II);

        return Result.succ(card_II);

    }


}
