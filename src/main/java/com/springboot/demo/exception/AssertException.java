package com.springboot.demo.exception;

//中转接口，提供一个异常对象。
public interface AssertException extends IResponseEnum,Assert{
    @Override
    default BaseException newExcetion() {
        return new ApiException(this);
    }

    @Override
    default BaseException newExcetion(String args) {
        setMessage(args);
        return new ApiException(this,args);
    }
}
