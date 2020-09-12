package com.edu.sort;

import java.util.Arrays;

/**
 * 快速排序算法
 *
 * @author lishiyan
 */
public class QuickSort {

    /**
     * @param arr        待排序数组
     * @param startIndex 基准元素位置
     * @param endIndex   最后一个元素位置
     */
    public void quickSort(int[] arr, int startIndex, int endIndex) {
        //递归结束条件：startIndex大于等于 endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素位置,使用单边循环法
        int pivotIndex = partition(arr, startIndex, endIndex);
        //根据基准元素，分成两部分递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);

    }

    /**
     * 分治（双边循环法）
     *
     * @param arr        待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return 基准元素
     */
    private int partition(int[] arr, int startIndex, int endIndex) {
        //取第一个元素作为基准元素（也可以选择随机位置）
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //控制right指针比较并左移
            while (left < right && arr[right] >= pivot) {//right<=pivot 从大到小
                //    p=6 2 7 3 8 9
                right--;                          //right>=pivot  从小到大
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <pivot) {//left>=pivot 从大到小
                left++;                          //left<=pivot 从小到大
            }
            //交换left和right指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    /**
     * 分治（单边循环法）
     *
     * @param arr        待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     */
    public int partitionDan(int[] arr, int startIndex, int endIndex) {
        //取第一个元素的位置
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,4};
        QuickSort q = new QuickSort();
        q.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
