package com.offer.sort;

import java.util.Arrays;

/**
 * @Author: Lisy
 * @Date: 2022/08/30/9:03
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(array));
        new QuickSort().quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        int low = start, high = end, pivot = array[start];
        while (low < high) {
            while (low <= high && array[low] <= pivot) {
                low++;
            }
            while (low <= high && array[high] >= pivot) {
                high--;
            }
            if (low < high) {
                swap(array, low, high);
            }
        }
        swap(array, start, high);
        return high;
    }

    private void swap(int[] array, int start, int high) {
        int tmp = array[start];
        array[start] = array[high];
        array[high] = tmp;
    }

}
