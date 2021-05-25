package com.springboot.demo.test2;

/**
 * synchronized 关键字测试
 */
public class SynchronizedDemo implements Runnable {
    Object o = new Object();
    Object o2 = new Object();

    @Override
    public void run() {
        synchronized (o){
            try {
                System.out.println("o1线程："+Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("o1线程："+Thread.currentThread().getName()+"结束");
        }
        synchronized (o2){
            try {
                System.out.println("o2线程："+Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("o2线程："+Thread.currentThread().getName()+"结束");
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        SynchronizedDemo synchronizedDemo2 = new SynchronizedDemo();
        new Thread(synchronizedDemo).start();
        new Thread(synchronizedDemo).start();

    }
}
