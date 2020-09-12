package com.ncst.sort;

/**
 * @Date 2020/9/12 9:00
 * @Author by LiShiYan
 * @Descaption
 */
public interface IArraySort {
    /**
     *
     * @param sourceArray 未排序的数组
     * @return 排序完之后的数组
     */
    int[] sort(int[] sourceArray);

    default void swap(int[] array, int index, int i) {
        int temp=array[index];
        array[index]=array[i];
        array[i]=temp;
    }
}
