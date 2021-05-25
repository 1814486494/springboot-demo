package com.springboot.demo.test2;

/**
 * volatile关键字测试
 */
public class VolatileDemo {
    int a = 1;
    int b = 2;

    public void change(){
        a = 3;
        b = a;
    }

    public void print(){
        System.out.println("a="+a+", b="+b);
    }

    public static void main(String[] args) {
        while (true){
            final VolatileDemo volatileDemo = new VolatileDemo();
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                volatileDemo.change();
            }).start();
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                volatileDemo.print();
            }).start();
        }
    }
}

class VolatileDemo2{
    volatile int a = 0;

    public void add(){
        a++;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo2 volatileDemo2 = new VolatileDemo2();
        for (int i = 0;i <= 1000;i++){
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                volatileDemo2.add();
            }).start();
        }
        Thread.sleep(10000);
        System.out.println(volatileDemo2.a);
    }


}