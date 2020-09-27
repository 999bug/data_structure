package com.ncst2.sort.cmp;


import com.ncst2.sort.Sort;

/**
 * @author hp
 */
public class InsertionSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        //从下标为1 的位置插入，下标为0 的位置默认有序
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            T v = array[cur];
            while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }

            //存在比其小的数，插入 ,不存在进行下轮循环
            if (cur != begin) {
                array[cur] = v;
            }

        }
    }

}
