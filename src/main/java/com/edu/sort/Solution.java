package com.edu.sort;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 8, 4, 3, 9, 1, 0};
        Solution solution = new Solution();
        int[] leastNumbers = solution.getLeastNumbers(array, 3);
        System.out.println(Arrays.toString(leastNumbers));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        //最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        //否则根据下标j与k的大小关系来决定继续切分左段还是右段
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标left，使得比nums[left]小的数都在left的左边，
    //比nums[left]大的数都在left的右边。
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int left = lo;
        int right = hi;
        while (left != right) {
            //控制right指针比较并左移
            while (left < right && nums[right] >= pivot) {
                right--;
            }

            //控制left指针比较并右移
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            //交换left和right指向的元素
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        //pivot和指针重合点交换
        nums[lo] = nums[left];
        nums[left] = pivot;
        return left;
    }
}