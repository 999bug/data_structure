package com.demo;

/**
 * @Date 2020/10/2 15:36
 * @Author by LSY
 * @Description
 */
public class test1 {
    static int i;

    public static void main(String[] args) {
        // 此时 i 为全局变量，未初始化会被赋予默认的初始化值！程序正确！
        System.out.println(i);
    }
}
