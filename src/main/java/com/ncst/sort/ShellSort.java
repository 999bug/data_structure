package com.ncst.sort;

import java.util.Arrays;

/**
 * @Date 2020/9/12 14:55
 * @Author by LiShiYan
 * @Descaption 希尔排序
 */
public class ShellSort implements IArraySort {

    /**
     * @param sourceArray 未排序的数组
     * @return 针对有序序列在插入时，采用交换法
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = array.length;

        //增量gap ，并逐步缩小增量
        for (int gap = len / 2; gap > 0; gap /= 2) {
            //从gap 个元素，逐个对其所在组直接插入排序操作
            for (int i = gap; i < len; i++) {
                int j = i;
                while (j - gap >= 0 && array[j] < array[j - gap]) {
                    //插入排序采用交换法
                    swap(array, j, j - gap);
                    j -= gap;
                }
            }
        }
        return array;
    }
}
