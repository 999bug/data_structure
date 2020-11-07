package com.ncst2.dynamic;

/**
 * @Date 2020/11/7 21:46
 * @Author by LSY
 * @Description 给定一个长度为 n 的整数序列，求它的最大连续子序列和 ?
 * 比如 –2、1、–3、4、–1、2、1、–5、4 的最大连续子序列和是 4 + (–1) + 2 + 1 = 6
 */
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i <nums.length ; i++) {
            if (dp <= 0 ){
                dp = nums[i];
            }else {
                dp = nums[i] + dp;
            }
            max = Math.max(max,dp);
        }
        return max;
    }
}
