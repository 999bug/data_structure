package com.ncst.sort;

import java.util.Arrays;

/**
 * @Date 2020/9/12 12:26
 * @Author by LiShiYan
 * @Descaption 选择排序
 */
public class SelectSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = array.length;
        //最小元素下标
        int min;

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < len - 1; i++) {
            min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (min != i) {
                swap(array, i, min);
            }
        }
        return array;
    }
}
