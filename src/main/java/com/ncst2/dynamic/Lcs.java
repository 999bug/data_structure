package com.ncst2.dynamic;

/**
 * @Date 2020/11/9 23:00
 * @Author by LSY
 * @Description 最长公共子序列（Longest Common Subsequence，LCS）
 * 求两个序列的最长公共子序列长度
 * [1, 3, 5, 9, 10] 和 [1, 4, 9, 10] 的最长公共子序列是 [1, 9, 10]，长度为 3
 * ABCBDAB 和 BDCABA 的最长公共子序列长度是 4，可能是
 * ✓ ABCBDAB 和 BDCABA > BDAB
 * ✓ ABCBDAB 和 BDCABA > BDAB
 * ✓ ABCBDAB 和 BDCABA > BCAB
 * ✓ ABCBDAB 和 BDCABA > BCBA
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class Lcs {
    public static void main(String[] args) {
        int len = new Lcs().lcs5(new int[]{1, 2, 5, 9, 10}, new int[]{1, 4, 9, 10});
        System.out.println("len = " + len);
    }

    /**
     * 假设两个序列分别为 nums1 nums2
     * i ∈ [1, nums1.length]
     * j ∈ [1, nums2.length]
     * 状态定义
     * dp(i,j) 是 nums1 的前 i 个元素与 nums2的前 j 个元素 的最长公共子序列
     * 初始值
     * dp(i,0)、dp(0,j) 初始值均为 0
     * 状态转移方程
     * nums1[i - 1] == nums2[j - 1] ==> dp(i,j) = dp(i -1, j - 1) + 1
     * nums1[i - 1] != nums2[j - 1] ==> dp(i,j) = max{dp(i -1, j),dp(i, j - 1) }
     */

    /**
     * dp 动态规划 + 一维数组
     */
    public int lcs5(int[] nums1, int[] nums2){
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        if (nums2 == null || nums2.length == 0) {
            return 0;
        }
        //选择数组元素少的当 列
        int[] rowsNums = nums1,colsNums = nums2;
        if (rowsNums.length < colsNums.length){
            colsNums = nums1;
            rowsNums = nums2;
        }
        int[] dp = new int[colsNums.length + 1];

        for (int i = 1; i <= rowsNums.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsNums.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (rowsNums[i - 1] == colsNums[j - 1]){
                    dp[j] = leftTop + 1;
                }else {
                    dp[j] =Math.max(dp[j],dp[j - 1]);
                }
            }
        }
        return dp[colsNums.length];
    }
    /**
     * dp 动态规划 + 一维数组
     */
    public int lcs4(int[] nums1, int[] nums2){
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        if (nums2 == null || nums2.length == 0) {
            return 0;
        }
        int[] dp = new int[nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= nums2.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[j] = leftTop + 1;
                }else {
                    dp[j] =Math.max(dp[j],dp[j - 1]);
                }
            }
        }
        return dp[nums2.length];
    }

    /**
     * dp 动态规划 + 滚动数组
     */
    public int lcs3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        if (nums2 == null || nums2.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            int row = i & 1;
            int preRow = (i - 1) & 1;
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[row][j] = dp[preRow][j - 1] + 1;
                } else {
                    dp[row][j] = Math.max(dp[row][j - 1], dp[preRow][j]);
                }
            }
        }
        return dp[nums1.length & 1][nums2.length];
    }

    /**
     * 非递归实现 dp 动态规划
     */
    public int lcs2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        if (nums2 == null || nums2.length == 0) {
            return 0;
        }
        /*
        			A	B	C	B	D	A	B    nums1
		        0	1	2	3	4	5	6	7
	        0	0	0	0	0	0	0	0	0
        B	1	0
        D	2	0
        C	3	0
        A	4	0
        B	5	0
        A	6	0

        nums2
         */
        //nums1.length + 1 目的是 前面需要加上一个 0
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }

    /**
     * 递归实现
     */
    public int lcs1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        if (nums2 == null || nums2.length == 0) {
            return 0;
        }
        return lcs1(nums1, nums1.length, nums2, nums2.length);
    }

    private int lcs1(int[] nums1, int i, int[] nums2, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (nums1[i - 1] != nums2[j - 1]) {
            return Math.max(
                    lcs1(nums1, i, nums2, j - 1), lcs1(nums1, i - 1, nums2, j)
            );
        }
        return lcs1(nums1, i - 1, nums2, j - 1) + 1;
    }
}
