package com.ncst2.sort.cmp;

import com.ncst2.sort.Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Date 2020/9/27 17:43
 * @Author by LiShiYan
 * @Descaption 希尔排序 复杂版本，最优 的计算步长算法
 */
public class ShellSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        List<Integer> list =sedgewickStepSequence();
        for (Integer step : list) {
            sort(step);
        }
    }

    /**
     * 分成step 列 进行排序
     */
    private void sort(int step) {
        //col : 第几列
        for (int col = 0; col < step; col++) {
            //col 为第一列 第 1 行元素
            // col +step 为第一列 第 2  行元素
            //col+2*step  为第一列 第 3 行元素
            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }
    }

    /**
     * @return 步长序列
     */
    private List<Integer> shellStepSequence() {
        List<Integer> list = new ArrayList<>();
        int step = array.length;
        while ((step >>= 1) > 0) {
            list.add(step);
        }
        return list;
    }

    /**
     * @return 目前最优的步长序列
     */
    private List<Integer> sedgewickStepSequence() {
        List<Integer> stepSequence = new LinkedList<>();
        int k = 0, step = 0;
        while (true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int) Math.pow(2, (k - 1) >> 1);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }
            if (step >= array.length) {
                break;
            }
            stepSequence.add(0, step);
            k++;
        }
        return stepSequence;
    }
}
