package com.leetcode.offer38;

import java.util.Arrays;

/**
 * @Date 2020/8/9 23:11
 * @Author by LiShiYan
 * @Descaption
 */
public class Test {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] abcs = solution.permutation("abc");
        System.out.println("abcs = " + Arrays.toString(abcs));

    }
}
