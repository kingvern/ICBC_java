package com.icbc.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.icbc.common.lang.dto.LoginDto;
import com.icbc.common.lang.Result;
import com.icbc.common.lang.dto.ResetPasswordDto;
import com.icbc.common.lang.dto.TxDto;
import com.icbc.entity.Captcha;
import com.icbc.entity.Card;
import com.icbc.entity.User;
import com.icbc.service.CaptchaService;
import com.icbc.service.CardService;
import com.icbc.service.UserService;
import com.icbc.util.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.icbc.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    CardService cardService;

    @Autowired
    CaptchaService captchaService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
//        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        User user = userQueryWrapper.and(wrapper -> wrapper.like("id_card", loginDto.getUsername()).or().like("phone_number", loginDto.getUsername()))
        User user = userService.getOne(new QueryWrapper<User>().eq("id_card", loginDto.getUsername()).or().eq("phone_number", loginDto.getUsername()));
        Card card_I = cardService.getOne(new QueryWrapper<Card>().eq("user_id", user.getId()).eq("level", '1'));
        Card card_II = cardService.getOne(new QueryWrapper<Card>().eq("user_id", user.getId()).eq("level", '2'));
        Assert.notNull(user, "用户不存在");
//        SecureUtil.md5(loginDto.getLoginPassword())
        if(!user.getLoginPassword().equals(loginDto.getLoginPassword())){
            return Result.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        return Result.succ(MapUtil.builder()
                .put("user", user)
                .put("card_I", card_I)
                .put("card_II", card_II)
                .map()
        );
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }

    @PostMapping("/reset")
    public Result reset(@Validated @RequestBody ResetPasswordDto resetPasswordDto) {
        System.out.println(resetPasswordDto.getUsername() +""+ resetPasswordDto.getIdCard());
        User user = userService.getOne(new QueryWrapper<User>().eq("phone_number", resetPasswordDto.getPhoneNumber()));
        Assert.notNull(user, "user不存在");

//        Captcha captcha = captchaService.getOne(new QueryWrapper<Card>().eq());
        User newUser = new User();
        newUser.setLoginPassword(resetPasswordDto.getLoginPassword());
        Assert.isTrue(resetPasswordDto.getLoginPassword().equals(resetPasswordDto.getLoginPasswordConfirm()), "密码不匹配");
        userService.update(newUser, new QueryWrapper<User>().eq("phone_number", resetPasswordDto.getPhoneNumber()));

        return Result.succ(user);
    }


}
