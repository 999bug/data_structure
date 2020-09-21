package com.leetcode;

import java.util.LinkedList;

/**
 * @Date 2020/9/20 19:36
 * @Author by LiShiYan
 * @Descaption
 */
public class 剑指_Offer_62_圆圈中最后剩下的数字 {
    public static void main(String[] args) {
        int i = lastRemaining(5, 3);
        System.out.println("i = " + i);
    }

    public static int lastRemaining(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n>1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}
