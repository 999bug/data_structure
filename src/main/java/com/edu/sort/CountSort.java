package com.edu.sort;

import com.edu.tree.HeapSort;

import java.util.Arrays;

/**
 * @author hp
 */
public class CountSort {

    /**
     * 计数排序
     *
     * @param array 待排序的数组
     * @return 排序后的数组
     */
    public  int[] countSort(int[] array) {
        //找出数组中元素最大的值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //创建新数组,根据数列最大值统计数组长度
        int[] arrCount = new int[max + 1];
        //遍历数列，填充统计数组
        for (int i = 0; i < array.length; i++) {
            arrCount[array[i]]++;
        }
        //遍历统计数组，输出结果
        int index = 0;
        int[] arrSorted = new int[array.length];

        for (int i = 0; i < arrCount.length; i++) {
            for (int j = 0; j < arrCount[i]; j++) {
                arrSorted[index++] = i;
            }
        }
        return arrSorted;
    }

    /**
     * 加强版计数排序
     *
     * @param array
     * @return
     */
    public  int[] countSortPro(int[] array) {
        //获取数组中的最大值和最小值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        //创建统计数组并统计对应元素个数
        int[] arrCount = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            arrCount[array[i] - min]++;
        }
        //统计数组做变形，后面的元素等于前面元素之和（代表排名）
        for (int i = 1; i < arrCount.length; i++) {
            arrCount[i] += arrCount[i - 1];
        }
        //倒序遍历原始队列，从统计数组找到正确位置，输出到结果数组
        int[] arrSorted = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            arrSorted[arrCount[array[i] - min] - 1] = array[i];
            arrCount[array[i] - min]--;//把变形数组所对应的元素减一（代表排名）
        }
        return arrSorted;
    }

   /* public static void main(String[] args) {
        int SIZE=8000000;
        int[] arr=new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            // 生成一个[0, SIZE) 数
            arr[i] = (int) (Math.random() * 8000000);
        }

        long start = System.currentTimeMillis();
        int[] sortedArray = countSort(arr);

        long time = System.currentTimeMillis() - start;
        System.out.println("CountSort所用时"+time);
      //  System.out.println(Arrays.toString(sortedArray));

        *//*int[] array2 = new int[]{90, 99, 95, 94, 95};
        int[] sortedArray2= countSortPro(array2);
        System.out.println(Arrays.toString(sortedArray2));*//*
    }*/
}
