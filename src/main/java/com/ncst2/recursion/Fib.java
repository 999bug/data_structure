package com.ncst2.recursion;

import com.ncst2.utils.Times;

/**
 * @Date 2020/10/29 22:09
 * @Author by LSY
 * @Description 斐波那契数列
 */
public class Fib {
    private static final int N = 10;

    public static void main(String[] args) {
        Times.test("fib", () -> {
            System.out.println(new Fib().fib(N));
        });
        Times.test("fib1", () -> {
            System.out.println(new Fib().fib1(N));
        });
        Times.test("fib2", () -> {
            System.out.println(new Fib().fib2(N));
        });
        Times.test("fib3", () -> {
            System.out.println(new Fib().fib3(N));
        });
        Times.test("fib4", () -> {
            System.out.println(new Fib().fib4(N));
        });
        Times.test("fib5", () -> {
            System.out.println(new Fib().fib5(N));
        });
    }

    /**
     * 自上向下的计算结果，存在重复计算问题
     */
    public int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 用数组存放计算过的结果，避免重复计算
     * 时间复杂度：O(n)，空间复杂度：O(n)
     */
    public int fib1(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[1] = arr[2] = 1;
        return fib1(n, arr);
    }

    private int fib1(int n, int[] arr) {
        if (arr[n] == 0) {
            arr[n] = fib1(n - 1, arr) + fib1(n - 2, arr);
        }
        return arr[n];
    }

    /**
     * 使用迭代 替换递归
     * 时间复杂度：O(n)，空间复杂度：O(n)
     * 这是一种 "自底向上"的计算过程
     */
    public int fib2(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[1] = arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 使用滚动数组
     * 时间复杂度：O(n)，空间复杂度：O(1)
     */
    public int fib3(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] arr = new int[2];
        arr[0] = arr[1] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i % 2] = arr[(i - 1) % 2] + arr[(i - 2) % 2];
        }
        return arr[n % 2];
    }

    /**
     * 使用滚动数组,位运算取代模运算
     * 时间复杂度：O(n)，空间复杂度：O(1)
     * 3 % 2 =  0b011 &1 = 1
     * 4 % 2 =  0b100 &1 = 0
     * 5 % 2 =  0b101 &1 = 1
     * 6 % 2 =  0b110 &1 = 0
     */
    public int fib4(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] arr = new int[2];
        arr[0] = arr[1] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i & 1] = arr[(i - 1) & 1] + arr[(i - 2) & 1];
        }
        return arr[n & 1];
    }

    /**
     * 使用自变量代替数滚动数组,位运算取代模运算
     * 时间复杂度：O(n)，空间复杂度：O(1)
     */
    public int fib5(int n) {
        if (n <= 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        for (int i = 3; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }


}
