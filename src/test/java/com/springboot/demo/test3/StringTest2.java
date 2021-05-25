package com.springboot.demo.test3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:linwenfeng
 * @Time:2021/5/25 11:14
 */
public class StringTest2 {

    //统计string内的重复字符
    public static void main(String[] args) {
        Map<Character,Integer> count = new HashMap<>();
        String str = "abcdaac";
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (count.containsKey(aChar)) {
                count.put(aChar,count.get(aChar)+1);
            } else {
                count.put(aChar,1);
            }
        }
        System.out.println(count);
    }
}