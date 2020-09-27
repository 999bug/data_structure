package com.ncst2.sort.cmp;

import com.ncst2.sort.Sort;

/**
 * @Date 2020/9/27 16:04
 * @Author by LiShiYan
 * @Descaption 快排
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        sort(0, array.length);
    }

    /**
     * 对 [begin, end) 范围的元素进行快速排序
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        //确定轴点位置
        int mid = pivotIndex(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    /**
     * 构造出 [begin, end) 范围的轴点元素
     *
     * @return 基准值
     */
    private int pivotIndex(int begin, int end) {
        //备份轴点元素
        T pivot = array[begin];
        //使end 指向数组最后一个元素的坐标上
        end--;
        while (begin < end) {
            //先从后开始比较
            while (begin < end) {
                //右边元素 > 轴点元素
                if (cmp(array[end], pivot) > 0) {
                    end--;
                } else {
                    //右边元素  <= 轴点元素
                    array[begin++]=array[end];
                    break;
                }
            }

            //从前开始比较
            while (begin < end) {
                //左边元素 < 轴点元素
                if (cmp(array[begin],pivot)<0){
                    begin++;
                }else {
                    //左边元素 >= 轴点元素
                    array[end--]=array[begin];
                    break;
                }
            }
        }
        //将轴点元素放入最终位置
        array[begin]=pivot;
        //返回轴点元素的下标
        return begin;
    }
}
