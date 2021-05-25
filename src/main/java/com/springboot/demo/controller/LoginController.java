package com.springboot.demo.controller;

import com.springboot.demo.bean.Token;
import com.springboot.demo.common.CommonResult;
import com.springboot.demo.util.DateUtil;
import com.springboot.demo.util.JWTUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author:linwenfeng
 * @Time:2020/10/26 18:34
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public CommonResult login(String username, String password){
        String a = "admin";
        String p = "123456";
        Token token = new Token();
        System.out.println(username+" : "+password);
        if (username.equals(a) && password.equals(p)){
            Date date = DateUtil.localDateTimePlusMin(LocalDateTime.now(), 15L);
            token.setToken(JWTUtil.generateToken(username));
            token.setRefreshToken(JWTUtil.generateRefreshToken(username));
            token.setExpireTimeStamp(date.getTime());
        }
        return CommonResult.success("登录成功", token);
    }
}
