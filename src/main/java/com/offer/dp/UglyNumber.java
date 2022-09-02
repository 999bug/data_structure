package com.offer.dp;

/**
 * @Author: Lisy
 * @Date: 2022/09/01/9:30
 * @Description: 丑数，我们把只包含2、3、5的数称为丑数，按顺序排列丑数，求第N个丑数
 */
public class UglyNumber {
    public static void main(String[] args) {
        int i = new UglyNumber().nthUglyNumber(11);
        System.out.println("i = " + i);
    }

    /**
     * 思路：丑数的递推性质：丑数只包含因子2、3、5，因此有丑数 = 某较小丑数 * 某因子
     *
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }


}
