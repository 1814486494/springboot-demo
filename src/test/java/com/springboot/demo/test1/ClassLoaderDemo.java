package com.springboot.demo.test1;

public class ClassLoaderDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(loader);
        //不加载初始化块
//        loader.loadClass("com.springboot.demo.test1.test.test");
        //执行静态代码块
        Class.forName("com.springboot.demo.test.test");
        //不执行代码块，并指定类加载器
//        Class.forName("com.springboot.demo.test1.test.test",false,loader);
    }

}

class test{

    public static Integer i = 1;

    static {
        i = 20;
        System.out.println("静态代码块执行 + i = "+i);
    }

    public test() {
        System.out.println("构造器执行");
    }
}