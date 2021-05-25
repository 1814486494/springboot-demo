package com.springboot.demo.exception;

//断言非空
public interface Assert {

    BaseException newExcetion();


    BaseException newExcetion(String args);

    default void assertNotNull(Object object){
        if (object == null){
            throw newExcetion();
        }
    }

    default void assertNotNull(Object object,String message){
        if (object == null){
            throw newExcetion(message);
        }
    }
}
