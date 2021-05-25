package com.springboot.demo.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.annotation.LoginCheckAnnotation;
import com.springboot.demo.bean.Message;
import com.springboot.demo.common.CommonResult;
import com.springboot.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author:linwenfeng
 * @Time:2020/10/23 10:06
 */
//@LoginCheckAnnotation
@RestController
public class Test1Controller {

    @Autowired
    MessageService messageService;

//    @LoginCheckAnnotation
    @RequestMapping("/test1")
    public CommonResult test1(){
        return CommonResult.success("1个测试");
    }


    @RequestMapping("/test2")
    public CommonResult test2(){
        return CommonResult.success("2个测试");
    }

    @LoginCheckAnnotation
    @RequestMapping("/test3")
    public CommonResult test3(HttpServletRequest request){
//        String token = request.getHeader("token");
//        JWTUtil jwtUtil = new JWTUtil(token);
//        Date expireTime = jwtUtil.getExpireTime();
//        System.out.println(expireTime.getTime());
        return CommonResult.success("123","abc");
    }

    @PostMapping("/getMsg")
//    @LogRecord(operating = "查看所有")
    public CommonResult getMsg(
           @RequestParam(name = "pageNum",defaultValue = "1",required = false) Integer pageNum,
           @RequestParam(name = "pageSize",defaultValue = "10",required = false) Integer pageSize
    ){
        List<Message> messages = messageService.selectAll(pageNum,pageSize);
        PageInfo<Message> pageInfo = new PageInfo<>(messages);
        return CommonResult.success("查询所有",pageInfo);
    }
}
