package com.ncst1.sort;

import java.util.Arrays;

/**
 * @Date 2020/9/12 9:17
 * @Author by LiShiYan
 * @Descaption 快排
 */
public class QuickSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(array, 0, array.length - 1);
    }

    /**
     * @param array 未排序的数组
     * @param start 默认0 为基准元素
     * @param end   数组最后一个元素位置
     * @return 快排后的数组
     */
    private int[] quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
        return array;
    }

    /**
     * @param array 数组
     * @param left  左面
     * @param right 右面
     * @return 基准元素 ,使用双边循环法
     */
    private int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int low = left;
        int high = right;
        while (low < high) {
            while (low <= high && array[low] <= pivot) {
                low++;
            }
            while (low <= high && array[high] >pivot) {
                high--;
            }
            if (low<high){
                swap(array,low,high);
            }
        }

        //重置pivot基准点，
        swap(array,left,high);
        return high;
    }
}
