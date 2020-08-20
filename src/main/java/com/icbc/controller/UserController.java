package com.icbc.controller;


import com.icbc.common.lang.Result;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    com.icbc.service.UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Result index() {
        com.icbc.entity.User user = userService.getById(1L);
        return Result.succ(user);
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody com.icbc.entity.User user) {
        return Result.succ(user);
    }


}
