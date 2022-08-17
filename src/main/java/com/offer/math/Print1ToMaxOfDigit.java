package com.offer.math;

import java.util.Arrays;

/**
 * @Author: Lisy
 * @Date: 2022/08/08/15:15
 * @Description: 打印1到最大的N位数，例如输入3,则打印1，2，3 。。。 999
 */
public class Print1ToMaxOfDigit {
    public static void main(String[] args) {
//        print1ToMaxOfDigitV1(2);
//        print1ToMaxOfDigitV2(2);

        long l = System.currentTimeMillis();
        System.out.println("l = " + l);
    }

    public static void print1ToMaxOfDigitV2(int digit) {
        // 二维数组第一个是行，第二个是列
        int[][] nums = new int[10][digit];
        int tmp = 0;
        for (int[] num : nums) {
            Arrays.fill(num, tmp);
            ++tmp;
        }
        int printDight = 1;
        int tn = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int i1 = nums[i][tn++];
                System.out.println("i1 = " + i1);
            }
        }

        System.out.println(Arrays.deepToString(nums));
    }

    public static void print1ToMaxOfDigitV1(int digit) {
        int tmp = 1;
        int i = 0;
        while (i++ < digit) {
            tmp *= 10;
        }
        System.out.println("tmp = " + tmp);
        for (int j = 1; j < tmp; j++) {
            System.out.println("j = " + j);
        }
    }
}
