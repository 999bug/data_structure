package com.edu.sort;

import java.util.Arrays;

public class heapSortDemo {

    /**
     * 下沉调整   **最小堆**
     *
     * @param array       待调整的数组
     * @param parentIndex 要下沉的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //tmp保存父节点值，用于最后的赋值
        int tmp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex<length){
            //如果有右孩子，且(右孩子大于左孩子的值)-->升序
            //             右孩子小于左孩子的值)-->降序序 ，则定位到右孩子
            if(childIndex+1<length&&array[childIndex+1]<array[childIndex]){
                childIndex++;
            }
            //如果父节点大于等于任何一个孩子的值，直接跳出(升序)
            //如果父节点小于等于任何一个孩子的值，直接跳出(降序)
            if (tmp<=array[childIndex]){
                break;
            }
            //无需真正交换，单向赋值即可
            array[parentIndex]=array[childIndex];
            parentIndex=childIndex;
            childIndex=2*childIndex+1;
        }
        array[parentIndex]=tmp;
    }

    /**
     * 堆排序（降序）
     * @param array  待调整的堆
     */
    public static void heapSort(int[] array){
        //创建堆
        for (int i = (array.length-2)/2; i >=0 ; i--) {
            downAdjust(array,i,array.length);
        }
        System.out.println(Arrays.toString(array));
        //循环交换集合尾部元素到堆顶，并调节产生新的堆顶
        for (int i = array.length-1 ;i>0; i--) {
            int tmp=array[i];
            array[i]=array[0];
            array[0]=tmp;
            //下沉调整最大堆
            downAdjust(array,0,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
