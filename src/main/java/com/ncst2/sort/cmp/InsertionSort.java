package com.ncst2.sort.cmp;


import com.ncst2.sort.Sort;

/**
 * 插入排序优化版本,采用挪动思想
 * @author hp
 */
public class InsertionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            //保存 begin 的值，下次循环使用
            int cur = begin;

            //保存插入的值，循环结束时，赋值到正确位置
            T value = array[cur];

            //每次和前一个元素比较大小，满足条件则向后挪动，覆盖当前位置
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
               array[cur]=array[cur-1];
                cur--;
            }

            //把插入的值，放到合适的位置
            array[cur]=value;
        }
    }
}
