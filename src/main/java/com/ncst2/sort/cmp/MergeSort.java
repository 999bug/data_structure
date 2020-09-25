package com.ncst2.sort.cmp;

import com.ncst2.sort.Sort;

/**
 * @Date 2020/9/25 21:50
 * @Author by LiShiYan
 * @Descaption 归并排序
 */
@SuppressWarnings("unchecked")
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    /**
     * 左边的数组
     */
    private T[] leftArray;

    @Override
    protected void sort() {
        leftArray = (T[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    /**
     * 对 [begin,end) 进行排序
     *
     * @param begin 左边界
     * @param end   右边界
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }

        int mid = (begin + end) >> 1;
        //left array
        sort(begin, mid);
        //right array
        sort(mid, end);
        //merge array
        merge(begin, mid, end);
    }

    /**
     * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列
     *
     * @param begin 起始位置
     * @param mid   中间位置
     * @param end   结束位置
     */
    private void merge(int begin, int mid, int end) {
        //li 为leftArray的索引起始位置，le 为leftArray 的结束位置
        int li = 0, le = mid - begin;
        //ri 为array 的右面起始位置，re 为array 的结束位置
        int ri = mid, re = end;
        //array 的索引
        int ai = begin;

        //备份临时数组
        if (le - li >= 0) {
            System.arraycopy(array, begin + li, leftArray, li, le - li);
        }
        /*for (int i = li; i <le ; i++) {
            leftArray[i]=array[begin+i];
        }*/

        //如果左面还没有结束
        while (li < le) {
            //右面的小于leftArray,且右边坐标小于结束值
            if (ri < re && cmp(array[ri], leftArray[li]) < 0) {
                //赋值，指针同时像后移动
                array[ai++] = array[ri++];
            } else {
                //右面的大于等于左面的
                array[ai++] = leftArray[li++];
            }
        }
    }
}
