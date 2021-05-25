package com.springboot.demo.exception;

//枚举接口
public interface IResponseEnum {

    int getCode();

    String getMessage();

    void setCode(int code);

    void setMessage(String args);
}
