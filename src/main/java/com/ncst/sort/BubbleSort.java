package com.ncst.sort;

import java.util.Arrays;

/**
 * @Date 2020/9/12 8:59
 * @Author by LiShiYan
 * @Descaption 冒泡排序算法
 */
public class BubbleSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) {
        boolean flag = false;
        //将源数组复制一份，不改变原数组数据
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            flag = true;
            for (int index = 0; index< len - i - 1; index++) {
                if (array[index]>array[index+1]){
                    swap(array,index,index+1);
                }
                flag = false;
            }

            if (flag){
                break;
            }
        }
        return array;
    }
}
