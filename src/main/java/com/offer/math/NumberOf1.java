package com.offer.math;

/**
 * @Author: Lisy
 * @Date: 2022/08/05/10:17
 * @Description:
 */
public class NumberOf1 {
    public static void main(String[] args) {
//        System.out.println(numberOf1(9));
//        boolean powerOf2 = isPowerOf2(-2);
//        System.out.println("powerOf2 = " + powerOf2);
        int i = changeN2M(10, 13);
        System.out.println("i = " + i);

        int i1 = Integer.parseInt("0123");
        System.out.println("i1 = " + i1);
    }

    /**
     * 通过将此数减一在对原数字进行与运算就能将最右面的1消除变成0
     */
    private static int numberOf1(int number) {
        System.out.println("入参" + number);
        int count = 0;
        while (number != 0) {
            count++;
            number = (number - 1) & number;
            System.out.println("number = " + number);
        }
        return count;
    }

    /**
     * 判断一个数是否为2的整数幂
     */
    private static boolean isPowerOf2(int number) {
        if (number < 2) {
            return false;
        }
        return ((number - 1) & number) == 0;
    }

    /**
     * 判断一个数 n 需要改变多少位可以转换成 m
     */
    private static int changeN2M(int n, int m) {
        return numberOf1(n ^ m);
    }
}
