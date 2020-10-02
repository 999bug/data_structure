package com.demo;

import java.util.Arrays;

/**
 * @Date 2020/10/2 15:36
 * @Author by LSY
 * @Description 可变参数
 */
public class test2 {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 34, 3, 342, 442, 424, 2};
        show(a);
        Arrays.binarySearch(a,4);
    }

    /**
     * @param a 此时这里写的就是可变参数 ， 和数组的作用一样
     */
    public static void show(int... a) {
        a[3]=3333;
        System.out.println(Arrays.toString(a));
    }
}
