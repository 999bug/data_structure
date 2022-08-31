package com.offer.arrayorpoint;

import java.util.Arrays;

/**
 * @Author: Lisy
 * @Date: 2022/08/31/14:37
 * @Description: 把数组排成最小的数
 */
public class MinNumber {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        String s = new MinNumber().minNumber(array);
        System.out.println("s = " + s);
    }

    public String minNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        quickSort(strings, 0, strings.length - 1);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(strings).forEach(sb::append);
        return sb.toString();
    }

    public void quickSort(String[] nums, int low, int high) {
        if (low < high) {
            int partition = partition(nums, low, high);
            quickSort(nums, low, partition - 1);
            quickSort(nums, partition + 1, high);
        }
    }

    private int partition(String[] nums, int low, int high) {
        String pivot = nums[low];
        while (low < high) {
            while (low < high && (nums[high] + pivot).compareTo((pivot + nums[high])) >= 0) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && (nums[low] + pivot).compareTo((pivot + nums[low])) <= 0) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

}
