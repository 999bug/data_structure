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
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                // if (array[begin] < array[begin - 1]) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }

}
