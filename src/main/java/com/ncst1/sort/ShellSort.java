package com.ncst1.sort;

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

        //增量step ，并逐步缩小增量
        for (int step = array.length / 2; step > 0; step /= 2) {
            //从gap 个元素，逐个对其所在组直接插入排序操作
            for (int begin = step; begin < array.length; begin++) {
                int cur = begin;
                while (cur - step >= 0 && array[cur] < array[cur - step]) {
                    //插入排序采用交换法
                    swap(array, cur, cur - step);
                    cur -= step;
                }
            }
        }
        return array;
    }
}
