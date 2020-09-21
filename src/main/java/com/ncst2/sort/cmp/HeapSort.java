package com.ncst2.sort.cmp;

import com.ncst2.sort.Sort;

/**
 * @Date 2020/9/21 22:51
 * @Author by LiShiYan
 * @Descaption
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    private int size;

    @Override
    protected void sort() {
        //原地建堆
        size = array.length;
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
        while (size > 1) {
            //交换堆顶云南苏和尾部元素
            swap(0, size - 1);
            size--;

            //对0位置进行siftDown(恢复堆的性质)
            siftDown(0);
        }
    }

    private void siftDown(int index) {
        //堆顶元素
        T element = array[index];

        //叶子节点
        int half = size >> 1;

        //index必须是非叶子节点
        while (index < half) {
            //默认是左边跟父节点比
            int childIndex = (index << 1) + 1;
            T child = array[childIndex];

            int rightIndex = childIndex + 1;
            //右子节点比左子节大
            if (rightIndex < size &&
                    cmp(array[rightIndex], child) > 0) {
                child = array[childIndex = rightIndex];
            }

            //大于等于子节点
            if (cmp(element, child) >= 0) {
                break;
            }
            array[index] = child;
            index = childIndex;

        }
        array[index] = element;
    }
}
