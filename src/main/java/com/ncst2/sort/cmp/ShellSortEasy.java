package com.ncst2.sort.cmp;

import com.ncst2.sort.Sort;

/**
 * @Date 2020/9/27 18:08
 * @Author by LiShiYan
 * @Descaption 希尔排序 简单版 采用shell 的计算步长的算法
 */
public class ShellSortEasy<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        //增量step ，并逐步缩小增量
        for (int step = array.length / 2; step > 0; step /= 2) {
            //从gap 个元素，逐个对其所在组直接插入排序操作
            for (int begin = step; begin < array.length; begin++) {
                int cur = begin;
                while (cur - step >= 0 && cmp(cur, cur - step) < 0) {
                    //插入排序采用交换法
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }
    }
}
