package com.springboot.demo.exception;

//枚举类继承接口，通过枚举类调用接口的默认方法抛出异常。
public enum ResponseEnum implements AssertException{
    /**
     * 第一个异常
     */
    FIRST_EXCEPTION(666, "first exception."),
    /**
     * 第二个异常
     */
    SECOND_EXCEPTION(777, "second exception.");

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
