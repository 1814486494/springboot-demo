package com.springboot.demo.test1;

import java.util.ArrayList;
import java.util.List;

public class StaticTest {

    public static List<String> i = new ArrayList<>();

    public String a = " 1 2 3 4";

    public Integer n1 = new Integer(22);
    public Integer n2 = new Integer(44);

    public String str;
    static {
        i.add("123");
        System.out.println("静态代码块");
    }

    public StaticTest() {
        System.out.println("构造");
    }

    public void a(){
       System.out.println("调用a");
   }

    public void a(String s) {
        System.out.println(s);
    }
}
