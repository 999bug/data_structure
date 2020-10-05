package com.demo;

/**
 * @Date 2020/10/2 16:34
 * @Author by LSY
 * @Description
 */
public class Test4  {
    public static void main(String[] args) {
        Integer a=127;
        Integer b=127;
        //-128 -- +127 之间的都是相等的
        System.out.println(a==b); //true
        Integer c=129;
        Integer d=129;
        System.out.println(c==d); //false
    }
}
