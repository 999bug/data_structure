package com.offer.sort;

import com.offer.arrayorpoint.MinNumber;

import java.util.Arrays;

/**
 * @Author: Lisy
 * @Date: 2022/08/31/14:54
 * @Description:
 */
public class QuickSortV2 {

    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(array));
        new QuickSortV2().quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int partition = partition(nums, low, high);
            quickSort(nums, low, partition - 1);
            quickSort(nums, partition + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }
}
