package com.ncst2.dynamic;

/**
 * @Date 2020/11/7 23:08
 * @Author by LSY
 * @Description 给定一个无序的整数序列，求出它最长上升子序列的长度（要求严格上升）
 * 比如 [10, 2, 2, 5, 1, 7, 101, 18] 的最长上升子序列是 [2, 5, 7, 101]、[2, 5, 7, 18]，长度是4
 */
public class Lis {
    /**
     状态定义
        假设 dp(i) 是以 nums[i] 结尾的最大连续子序列和（nums是整个序列）
     状态转移方程
       设 j ∈ [0,i) 考虑每轮计算新的dp[i]时，遍历 [0,i)列表区间做如下判断
         nums[i] > nums[j] 此情况nums[i] 可以 在 nums[j] 之后 此情况下最长上升子序列长度为 dp[j] + 1
         nums[i] <= nums[j] 此情况 nums[i] 无法 在 nums[j] 之后 ，continue 跳出本次循环
     初始状态
        dp[i] 的所有元素设置为 1 含义是每个元素都至少可以单独成为子序列，此时长度都为 1.
     返回值
         最大连续子序列和是所有 dp(i) 中的最大值 max { dp(i) }, i∈[0,nums.length)
     */

    public static void main(String[] args) {
        System.out.println(new Lis().lengthOfLIS(new int[]{10, 2, 2, 5, 1, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                //以 j 为末尾的 元素小于 i 则 构不成上升子序列
                if (nums[i] <= nums[j]){
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return  max;
    }
}
