package com.springboot.demo.common;

public enum ResultEnum {
    SUCCESS(200), FAIL(500);

    private final int value;

    ResultEnum(int value) {
        this.value = value;
    }

    int getValue(){
        return value;
    }
}
