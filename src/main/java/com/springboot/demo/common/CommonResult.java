package com.springboot.demo.common;

import com.springboot.demo.bean.Token;
import lombok.Data;

/*公共返回类*/
@Data
public class  CommonResult<T> {

    private int code;
    private String message;
    private T data;
    private Token token;

    private static final int success = ResultEnum.SUCCESS.getValue();
    private static final int fail = ResultEnum.FAIL.getValue();

    private CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    private CommonResult(int code, String message, T data,Token token) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.token = token;
    }

    public static CommonResult success(){
        return new CommonResult(success,null,null);
    }

    public static CommonResult success(String message){
        return new CommonResult(success,message,null);
    }

    public static <T>CommonResult success(T data){
        return new CommonResult(success,null,null);
    }

    public static <T> CommonResult success(String message,T data){
        return new CommonResult(success,message,data);
    }

    public static CommonResult success(String message,Token token){
        return new CommonResult(success,message,null,token);
    }

    public static <T> CommonResult success(String message,T data,Token token){
        return new CommonResult(success,message,data,token);
    }

    public static CommonResult fail(){
        return new CommonResult(fail,null,null);
    }

    public static CommonResult fail(String message){
        return new CommonResult(fail,message,null);
    }

    public static <T> CommonResult fail(String message,T data){
        return new CommonResult(fail,message,data);
    }
}
