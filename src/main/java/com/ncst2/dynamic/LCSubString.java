package com.ncst2.dynamic;

/**
 * @Date 2020/11/15 20:35
 * @Author by LSY
 * @Description 最长公共子串问题
 * 求两个字符串的最长公共子串长度
 * ABCBA 和 BABCA 的最长公共子串是 ABC，长度为 3
 */
public class LCSubString {
    public static void main(String[] args) {
        System.out.println(new LCSubString().lcs("ABCBA ", "CBA"));
    }
    /**
     * 假设两个字符串分别是str1、str2
     * i ∈ [1,str1.length]
     * j ∈ [1,str2.length]
     * 状态定义 ：
     *      假设dp(i,j)是以 str1[i - 1]、 str2[j - 1]结尾的最长公共子串长度
     *      如果str1[i - 1] == str2[j - 1] 那么 dp(i,j) = dp(i - 1, j - 1) + 1;
     *      如果str1[i - 1] != str2[j - 1] 那么 dp(i,j) = 0;
     * 初始值
     *      dp(i,0)、dp(0,j) 初始值均为 0
     * 返回值
     *      最长公共子串的长度是所有 dp(i,j) 中最大值 max{dp(i,j)};
     */

    /**
     * 一维数组实现
     * 时间复杂度 O(M * N)
     * 空间复杂度 O(K) K = min(m,n)
     */
    public int lcs(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        if (chars1.length == 0 || chars2.length == 0) {
            return 0;
        }
        char[] rowsStr = chars1, colsStr = chars2;
        //使用数组长度最小的当数组长度
        if (rowsStr.length < colsStr.length) {
            colsStr = chars1;
            rowsStr = chars2;
        }
        //初始值默认为 0
        int[] dp = new int[colsStr.length + 1];
        int max = 0;
        //从后像前循环就不用存储左上角的值了，这样就省去存数左上角的值那一个步骤
        for (int i = 1; i <= rowsStr.length; i++) {
            for (int j = colsStr.length; j >= 1; j--) {
                //如果不等于则进行下一次循环
                if (rowsStr[i - 1] == colsStr[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                max = Math.max(dp[j], max);
            }
        }
        return max;
    }

    /**
     * 一维数组实现
     * 时间复杂度 O(M * N)
     * 空间复杂度 O(K) K = min(m,n)
     */
    public int lcs2(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        if (chars1.length == 0 || chars2.length == 0) {
            return 0;
        }
        char[] rowsStr = chars1, colsStr = chars2;
        //使用数组长度最小的当数组长度
        if (rowsStr.length < colsStr.length) {
            colsStr = chars1;
            rowsStr = chars2;
        }
        //初始值默认为 0
        int[] dp = new int[colsStr.length + 1];
        int max = 0;
        for (int i = 1; i <= rowsStr.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsStr.length; j++) {
                //保存左上角的那个值
                int leftTop = cur;
                cur = dp[j];
                //如果不等于则进行下一次循环
                if (rowsStr[i - 1] == colsStr[j - 1]) {
                    dp[j] = leftTop + 1;
                    max = Math.max(dp[j], max);
                } else {
                    dp[j] = 0;
                }

            }
        }
        return max;
    }

    /**
     * 多维数组实现
     * 时间复杂度 O(M * N)
     * 空间复杂度 O(M * N)
     */
    public int lcs1(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        if (chars1.length == 0 || chars2.length == 0) {
            return 0;
        }
        //初始值默认为 0
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        int max = 0;
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                //如果不等于则进行下一次循环
                if (chars1[i - 1] != chars2[j - 1]) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + 1;
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
