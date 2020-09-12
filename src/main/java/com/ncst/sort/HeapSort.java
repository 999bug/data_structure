package com.ncst.sort;

import com.ncst.linearlist.AbstractList;

import java.util.Arrays;

/**
 * @Date 2020/9/12 17:39
 * @Author by LiShiYan
 * @Descaption 堆排序
 */
public class HeapSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = array.length;
        buildMinHeap(array, len);

        //2.将堆顶元素与末尾元素交换，将 arr[0] 元素"沉"到数组末端
        //3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，
        // 反复执行调整+交换步骤，直到整个序列有序。
        for (int i = len - 1; i > 0; i--) {
            swap(array, 0, i);
            //把数组长度 减 1
            len--;
            adjustHeapDesc(array, 0, len);
        }
        return array;
    }

    /**
     * 构建大顶堆,
     *  取堆顶元素放到 数组 的 最后一个位置（i），依次放在(i --) 位置
     * @param array  数组
     * @param length 数组长度
     */
    private void buildMaxHeap(int[] array, int length) {
        for (int i = length >> 1; i >= 0; i--) {
            adjustHeapAsc(array, i, length);
        }
    }

    /**
     * 构建小顶堆
     *
     * @param array  数组
     * @param length 数组长度
     */
    private void buildMinHeap(int[] array, int length) {
        for (int i = length >> 1; i >= 0; i--) {
            adjustHeapDesc(array, i, length);
        }
    }

    /**
     * 调整为升序
     *
     * @param array
     * @param i
     * @param len
     */
    private void adjustHeapDesc(int[] array, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && array[left] < array[largest]) {
            largest = left;
        }

        if (right < len && array[right] < array[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(array, i, largest);
            adjustHeapDesc(array, largest, len);
        }
    }

    private void adjustHeapAsc(int[] array, int i, int len) {
        int left = 2 * i + 1;
        int tmp = array[i];
        for (int k = left; k < len; k = k * 2 + 1) {
            //左子节点小于右子节点，指针右移
            if (k + 1 < len && array[k] < array[k + 1]) {
                k++;
            }

            //如果子节点大于父子结点
            if (array[k]>tmp){
                //交换父子结点  arr[i]: 父结点  arr[k]:子结点
                array[i]=array[k];

                //父结点i 等于 子结点k 继续循环比较
                i=k;
            }else {
                break;
            }
        }
        //当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了 最顶(局部)
        //将temp值放到调整后的位置
        array[i]=tmp;
    }
}
