package com.ncst2.divide;

/**
 * @Date 2020/11/5 20:22
 * @Author by LSY
 * @Description 最大连续子序列和
 */
public class MaxSubarray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return maxSubArray(nums, 0, nums.length);
    }

    /**
     * 求解[begin, end)中最大连续子序列的和
     * T(n) = T(n/2) + T(n/2) + O(n)
     * T(n) = 2T(n/2) + O(n)
     * logba = 1  d = 1
     */
    private int maxSubArray(int[] nums, int begin, int end) {
        //不足两个 元素
        if (end - begin < 2) {
            return nums[begin];
        }
        int mid = (begin + end) >> 1;
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i <end ; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax,rightSum);
        }
        return Math.max(leftMax + rightMax,
                Math.max(maxSubArray(nums, begin, mid),
                        maxSubArray(nums, mid, end))
        );
    }
}
