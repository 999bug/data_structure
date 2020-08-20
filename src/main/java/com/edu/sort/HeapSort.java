package com.edu.sort;

/**
 * @Date 2020/6/9 9:13
 * @Author by LiShiYan
 * @Description 堆排序
 */
public class HeapSort {

    /**
     * 堆排序，根据最大堆，最小堆选择
     *
     * @param arr 待排序数组
     */
    public void heapSort(int[] arr) {
        int temp = 0;
        //1.将无序数组构建成一个堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeapDesc(arr, i, arr.length);
        }

        //2.将堆顶元素与末尾元素交换，将 arr[0] 元素"沉"到数组末端
        //3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeapDesc(arr, 0, i);
        }

    }

    /**
     * 将一个数组(二叉树), 调整成一个小顶堆
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引 arr.length/2-1
     * @param length 数组的大小
     */
    public void adjustHeapDesc(int[] arr, int i, int length) {
        //定义临时变量
        int temp = arr[i];

        //循环开始，定位到 i 的左子结点，
        for (int j = i * 2 + 1; j < length; j = i * 2 + 1) {
            //如果左子结点大于右子结点，指针右移
            if (j + 1 < length && arr[j] > arr[j + 1]) {
                j++;
            }
            //如果子结点小于父节点
            if (arr[j] < temp) {
                //交换父子结点  arr[i]: 父结点  arr[j]:子结点
                arr[i] = arr[j];
                //父结点i 等于子结点j  继续循环比较
                i = j;
            } else {
                //子结点大于父结点退出循环
                break;
            }
            arr[i] = temp;
        }
    }

    /**
     * 将一个数组(二叉树), 调整成一个大顶堆
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引 arr.length/2-1
     * @param length 数组的大小
     */
    public void adjustHeapAsc(int[] arr, int i, int length) {
        //取出当前元素的值，保存到临时变量
        int temp = arr[i];

        //循环开始时，k指向 i 结点的 左子结点
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            //左子结点小于右子结点时，指针右移
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //k指向右子结点
                k++;
            }
            //如果子结点大于父节点
            if (arr[k] > temp) {
                //交换父子结点  arr[i]: 父结点  arr[k]:子结点
                arr[i] = arr[k];
                //父结点i 等于 子结点k 继续循环比较
                i = k;
            } else {
                //子结点小于父节点退出循环
                break;
            }
        }
        //当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了 最顶(局部)
        //将temp值放到调整后的位置
        arr[i] = temp;
    }
}
