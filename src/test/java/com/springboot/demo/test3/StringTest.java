package com.springboot.demo.test3;

import java.lang.reflect.Field;

public class StringTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        final String name = "12345";
        Class<? extends String> aClass = name.getClass();
        Field value = aClass.getDeclaredField("value");
        value.setAccessible(true);
        char[] c = (char[]) value.get(name);
        c[1] = 'a';
        System.out.println(name);
    }
}
