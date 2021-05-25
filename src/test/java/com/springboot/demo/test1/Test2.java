package com.springboot.demo.test1;

/**
 * @Author:linwenfeng
 * @Time:2020/10/29 15:01
 */
public class Test2 {

    public static void main(String[] args) throws Exception {
//        Long s = 1606645378000L;
////        Date date = new Date(1606645378000L);
////        String s1 = DateUtil.dateFormat(date);
////        System.out.println(new Date().after(new Date(new Date().getTime()-1000L)));
        String[] str = {"1","2"};
        Test1.main(str);
//        test1();
//        new Test1().ordinary2();
//        test2();
    }


    public static void test1(){
        System.out.println("第一个静态方法");
    }

    public static void test2(){
        System.out.println("第二个静态方法");
    }

    public void ordinary1(){
        System.out.println("第一个普通方法");
    }
}
