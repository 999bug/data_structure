package com.ncst2.sort.cmp;

import com.ncst2.sort.Sort;
import com.ncst2.utils.Integers;

/**
 * @Date 2020/9/21 20:28
 * @Author by LiShiYan
 * @Descaption 冒泡排序
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        int len = array.length;
        //设置边界
        int sortedIndex = 1;
        for (int end = 0; end < len - 1; end++) {
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                }
                sortedIndex = begin;
            }
            end = sortedIndex;
        }
    }

}
