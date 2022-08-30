package com.offer.arrayorpoint;

/**
 * @Author: Lisy
 * @Date: 2022/08/30/15:04
 * @Description: 从1到n整数中1出现的次数
 */
public class NumberOf1AppearNums {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int i = new NumberOf1AppearNums().countDigitOne(824883294);
        System.out.println("S" + (System.currentTimeMillis()-l));
        System.out.println("i = " + i);
    }

    public int countDigitOne(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numberOf1(i);
        }
        return sum;
    }


    int numberOf1(int num) {
        int sum = 0;
        while (num != 0) {
            if (num % 10 == 1) {
                sum++;
            }
            num /= 10;
        }
        return sum;
    }
}
