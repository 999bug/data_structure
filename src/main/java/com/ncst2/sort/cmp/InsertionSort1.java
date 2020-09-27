package com.ncst2.sort.cmp;


import com.ncst2.sort.Sort;

/**
 * 插入排序的简单版本，采用交换思想
 */
public class InsertionSort1<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            //保存 begin 的值，下次循环使用
            int cur = begin;
            //每次和前一个元素比较大小，满足条件则交换，直到 cur<= 0 结束本次循环
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }

}
