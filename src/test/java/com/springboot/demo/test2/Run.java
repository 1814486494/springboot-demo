package com.springboot.demo.test2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程测试
 */
public class Run extends Thread{

    public static void main(String[] args) throws InterruptedException {
//        ThreadDemo1 threadDemo1 = new ThreadDemo1();
//        ThreadDemo2 threadDemo2 = new ThreadDemo2();
//        Thread thread1 = new Thread(threadDemo1);
//        Thread thread2 = new Thread(threadDemo2);
//        thread1.setName("线程1");
//        thread2.setName("线程2");
//        thread1.start();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread2.start();

        TestBean testBean = new TestBean();
//        Thread t1 = new Thread(() -> {
//            while (true){
//                testBean.addo();
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() +": "+ testBean.o);
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            while (true){
//                testBean.addo();
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() +": "+ testBean.o);
//            }
//        });
//        t1.setName("线程1");
//        t2.setName("线程2");
//        t1.start();
//        Thread.sleep(1000);
//        t2.start();


        ExecutorService e = Executors.newCachedThreadPool();
        e.execute(() -> {
            for (int i = 0; i < 50; i++) {
                testBean.addo();
                System.out.println(Thread.currentThread().getName()+": "+testBean.o);
            }
        });
        e.execute(() -> {
            for (int i = 0; i < 50; i++) {
                testBean.addo();
                System.out.println(Thread.currentThread().getName()+": "+testBean.o);
            }
        });
        e.shutdown();
    }
}
