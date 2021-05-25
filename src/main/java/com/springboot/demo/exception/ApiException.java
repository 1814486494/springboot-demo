package com.springboot.demo.exception;

//要抛出的异常
public class ApiException extends BaseException {
    public ApiException(IResponseEnum responseEnum) {
        super(responseEnum);
    }

    public ApiException(IResponseEnum responseEnum,String args) {
        super(responseEnum,args);
    }
}
