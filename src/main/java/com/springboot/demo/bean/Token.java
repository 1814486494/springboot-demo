package com.springboot.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * @Author:linwenfeng
 * @Time:2020/10/29 15:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    //普通token
    private String token;

    //刷新用token
    private String refreshToken;

    //普通token过期时间戳，用于判断token是否过期
    private Long expireTimeStamp;
}
