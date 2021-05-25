package com.springboot.demo.exception;

public class T1 extends BaseException implements IResponseEnum {

    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.t1(null);
    }

    public void t1(Object o){
        ResponseEnum.FIRST_EXCEPTION.assertNotNull(o);
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public void setCode(int code) {

    }

    @Override
    public void setMessage(String args) {

    }
}
