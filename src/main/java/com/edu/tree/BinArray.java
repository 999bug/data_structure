package com.edu.tree;

import java.util.Arrays;

/**
 * @author hp
 * 二叉堆
 */
public class BinArray {

    /**
     * 上浮调整
     *
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        int childindex = array.length - 1;//找到孩子节点的左节点
        int parrentIndex = (childindex - 1) / 2;
        //temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childindex];
        while (childindex > 0 && temp < array[parrentIndex]) {
            //无需真正交换，单向赋值即可
            array[childindex] = array[parrentIndex];
            childindex = parrentIndex;
            parrentIndex = (parrentIndex - 1) / 2;
        }
        array[childindex] = temp;
    }


    /**
     * 下沉调整
     *
     * @param array       待调整的数组
     * @param parentIndex 要下沉的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //temp保存父节点的值，用于最后赋值
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值，直接跳出
            if (temp <= array[childIndex])
                break;
            //无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 创建二叉堆
     *
     * @param array
     */
    public static void buildHeap(int[] array) {

        //从最后一个非叶子子节点开始，依次做下沉调整
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        //上浮
        int[] array = new int[]{1, 10, 2, 3, 6, 7, 8, 9,12};

        upAdjust(array);
        System.out.println("up" + Arrays.toString(array));
        //创建二叉堆
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
