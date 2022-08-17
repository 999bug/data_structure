package com.offer.math;

/**
 * @Author: Lisy
 * @Date: 2022/08/08/14:43
 * @Description: 使用非库函数的方式计算出数字的N次方
 */
public class PowerWithExponent {

    public static void main(String[] args) {
        double v = powerWithExponent(3.5, 45);
        System.out.println("v = " + v);
        System.out.println("Math.pow(3.5, 5) = " + Math.pow(2, 932));
    }
    public static double powerWithExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = powerWithExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }
}
