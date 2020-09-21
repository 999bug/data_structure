package com.ncst2.sort.cmp;

import com.ncst2.sort.Sort;
import com.ncst2.utils.Integers;

/**
 * @Date 2020/9/21 21:06
 * @Author by LiShiYan
 * @Descaption
 */
public class SelectSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int i = array.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (cmp(maxIndex, j) <= 0) {
                    maxIndex = j;
                }
            }
            swap(maxIndex, i);
        }
    }
}
