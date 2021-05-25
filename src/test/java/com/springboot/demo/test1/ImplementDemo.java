package com.springboot.demo.test1;

import java.util.ArrayList;
import java.util.List;

public class ImplementDemo implements InterfaceDemo {
    @Override
    public void test1() {
        System.out.println(1);
    }


    public static void test2() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        test2();
        List<String> l = new ArrayList();
        l.add("123");
        l.add("456");
        l.add("789");
        l.add("000");
        l.add("000");
        l.stream().distinct().forEach(new StaticTest()::a);
//        l.stream().filter(s -> s.equals("123")).forEach(s -> {
//            System.out.println(s);
//        });
    }
}
