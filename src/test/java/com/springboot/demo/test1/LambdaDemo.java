package com.springboot.demo.test1;

@FunctionalInterface
public interface LambdaDemo {
    void study();

    default void my(){
        System.out.println("一个默认方法");
    }
}

class TestLambda{

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = () -> System.out.println("自定义lambda");
        lambdaDemo.study();
        lambdaDemo.my();
    }
}