package com.offer.arrayorpoint;

import java.util.Arrays;

/**
 * @Author: Lisy
 * @Date: 2022/08/29/9:44
 * @Description: 最小的K个数
 */
public class LeastKNumbers {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(array));
        int[] leastNumbers = new LeastKNumbers().getLeastNumbers(array, 4);
        System.out.println(Arrays.toString(leastNumbers));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length < 1) {
            return null;
        }
        int[] ints = quickSort(arr, 0, arr.length - 1);
        System.out.println("DDDD" + Arrays.toString(ints));
        return Arrays.copyOf(ints, k);
    }

    private int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left], low = left, high = right;

        while (low < high) {
            while (low <= high && arr[low] <= pivot) {
                low++;
            }
            while (low <= high && arr[high] >= pivot) {
                high--;
            }
            if (low < high) {
                swap(arr, low, high);
            }
        }
        swap(arr, left, high);
        return high;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
