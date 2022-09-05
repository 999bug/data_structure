package com.offer.arrayorpoint;

import java.util.Arrays;

/**
 * @Author: Lisy
 * @Date: 2022/09/05/10:05
 * @Description: 数字在排序数组中出现的次数或者坐标
 */
public class SearchRangeNums {
    public static void main(String[] args) {
        int[] array = new int[]{5,7,7,8,8,10};
        int[] ints = new SearchRangeNums().searchRange(array, 8);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        int lstPosition = findLstPosition(nums, target);
        int i = lstPosition - firstPosition + 1;
        System.out.println("i = " + i);
        return new int[]{firstPosition, lstPosition};
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1, middle;
        while (left < right) {
            middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findLstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1, middle;
        while (left < right) {
            // 中间值取后面那个
            //  相当于 middle = (left + right + 1) / 2， 防止大数越界;
            middle = left + (right - left + 1) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }
        return left;
    }
}
