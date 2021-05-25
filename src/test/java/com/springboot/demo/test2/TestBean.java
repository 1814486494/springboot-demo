package com.springboot.demo.test2;

public class TestBean {

    public static Integer i = 0;

    public Integer o = 100;

    public String s = "no";

    public static void add(){
        i++;
    }

    public void addo(){
        synchronized (this){
            o++;
        }
    }
}
