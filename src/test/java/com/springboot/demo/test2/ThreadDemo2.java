package com.springboot.demo.test2;

public class ThreadDemo2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TestBean.add();
            System.out.println(Thread.currentThread().getName()+": "+ TestBean.i);
        }
    }
}
