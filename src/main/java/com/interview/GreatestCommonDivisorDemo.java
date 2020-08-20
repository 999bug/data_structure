package com.interview;

/**
 * @Date 2020/5/23 12:41
 * @Author by hp
 * @Description 最大公约数
 */
public class GreatestCommonDivisorDemo {

    /**
     * 辗转相除法
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max % min == 0) {
            return min;
        }
        return getGreatestCommonDivisor(max % min, min);
    }

    /**
     * 更相减损法
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorChina(int a, int b) {
        if (a == b) {
            return a;
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return getGreatestCommonDivisorChina(max - min, min);
    }

    /**
     * 最优解发，结合使用
     * @param a
     * @param b
     * @return
     * 判断整数奇偶性的方式是让整数和1进行与运算，
     * 如果(a&1)==0，则说明整数a是偶数；
     * 如果(a&1)!=0，则说明整数a是奇数。
     */
    public static int gcd(int a, int b) {
        //递归终止条件
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return gcd(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return gcd(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return gcd(a, b >> 1);
        } else {
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            return gcd(max - min, min);
        }
    }

    public static void main(String[] args) {
         System.out.println(gcd(25, 5));
         System.out.println(gcd(100, 80));
         System.out.println(gcd(27, 14));

    }
}
