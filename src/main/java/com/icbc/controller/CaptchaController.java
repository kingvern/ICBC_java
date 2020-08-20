package com.icbc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.icbc.common.lang.Result;
import com.icbc.entity.Captcha;
import com.icbc.entity.Card;
import com.icbc.entity.User;
import com.icbc.service.CaptchaService;
import com.icbc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kingvern
 * @since 2020-08-19
 */
@RestController
public class CaptchaController {

    @Autowired
    CaptchaService captchaService;

    @Autowired
    UserService userService;

    @GetMapping("/captcha/{phoneNumber}")
    public Result get(@PathVariable(name = "phoneNumber") String phoneNumber, @RequestParam(defaultValue = "1")Integer behavior) {
        Captcha temp = new Captcha();

//        Captcha lastOne = captchaService.getOne(new QueryWrapper<Captcha>().eq("user_phone_number", phoneNumber));
        User user = userService.getOne(new QueryWrapper<User>().eq("phone_number", phoneNumber));
        temp.setUserPhoneNumber(phoneNumber);
        temp.setBehavior(behavior);
        temp.setCaptchaCode("123123");
        LocalDateTime localNow = LocalDateTime.now();
        temp.setAddTime(LocalDateTime.now());
        temp.setExpirationDate(localNow.plusMinutes(2));
        temp.setUserId(user.getId());
        captchaService.save(temp);
        return Result.succ(temp);
    }
}
