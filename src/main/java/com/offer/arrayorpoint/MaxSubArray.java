package com.offer.arrayorpoint;

/**
 * @Author: Lisy
 * @Date: 2022/08/30/9:51
 * @Description: 连续数组的最大和
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int maxNum = Integer.MIN_VALUE;
        int res = 0;
        for (int num : nums) {
            if (res <= 0) {
                res = num;
            } else {
                res += num;
            }
            if (res > maxNum) {
                maxNum = res;
            }
        }
        return maxNum;
    }
}
