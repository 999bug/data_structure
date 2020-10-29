package com.leetcode;

/**
 * @Date 2020/10/26 20:52
 * @Author by LSY
 * @Description
 */
public class 剑指_Offer_53_II_0_n_1中缺失的数字 {
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (nums[m] == m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
