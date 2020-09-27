package com.ncst1.sort;

import java.util.Arrays;

/**
 * @Date 2020/9/12 12:03
 * @Author by LiShiYan
 * @Descaption 插入排序
 */
public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {

        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        //从下标为1 的位置插入，下标为0 的位置默认有序
        for (int begin = 1; begin < array.length; begin++) {

            //从已经排序的序列最右边开始比较，找到最小的数
            int cur = begin;
            //记录要插入的数据
            int tmp = array[cur];

            while (cur > 0 && tmp < array[cur - 1]) {
                array[cur] = array[cur - 1];
                cur--;
            }
            //存在比其小的数，插入
            if (cur != begin) {
                array[cur] = tmp;
            }
        }
        return array;
    }
}
