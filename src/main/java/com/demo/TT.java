package com.demo;

/**
 * @Date 2020/10/3 14:17
 * @Author by LSY
 * @Description
 */
public interface TT {
    void test1();

    default void test2() {
        System.out.println("jdk8");
    }
}
