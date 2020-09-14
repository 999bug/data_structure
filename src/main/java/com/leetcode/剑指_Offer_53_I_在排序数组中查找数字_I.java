package com.leetcode;

/**
 * @Date 2020/9/14 14:41
 * @Author by LiShiYan
 * @Descaption https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class 剑指_Offer_53_I_在排序数组中查找数字_I {
    public static void main(String[] args) {
        int search = search1(new int[]{5, 7, 7, 8, 8, 8, 10}, 8);
        System.out.println("search = " + search);
    }

    public static int search1(int[] nums, int target) {

        return helper(nums, target) - helper(nums, target - 1);
    }

    private static int helper(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >>1);
            if (target >= nums[middle]) {
                low=middle+1;
            }else {
                high=middle-1;
            }
        }
        return low;
    }

    public static int search(int[] nums, int target) {
        //搜索右边界
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (target >= nums[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        int right = low;

        //若数组中 无target，则提前返回
        if (high >= 0 && nums[high] != target) {
            return 0;
        }

        //搜索左边界
        low = 0;
        high = len - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (target > nums[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        int left = high;

        return (right - left - 1);
    }


}
