package com.leetcode;

import java.util.Arrays;

/**
 * @Date 2020/9/26 8:37
 * @Author by LiShiYan
 * @Descaption
 */
public class _88_合并两个有序数组 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            if (n >= 0) {
                System.arraycopy(nums2, 0, nums1, 0, n);
            }
        }
        int le = m - 1;
        int re = n - 1;
        int tail = m + n - 1;

        while (le != 0) {
            if (re > 0 && (nums1[le] < nums2[re])) {
                nums1[tail--] = nums2[re--];
            } else {
                nums1[tail--] = nums1[le--];
            }
        }

        while (re != 0) {
            nums1[tail--] = nums2[re--];
        }
    }
}


