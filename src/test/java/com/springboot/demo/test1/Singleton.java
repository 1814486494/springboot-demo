package com.springboot.demo.test1;

public class Singleton {

    private Singleton(){};

    private static Singleton singleton;

    public int a;

    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
