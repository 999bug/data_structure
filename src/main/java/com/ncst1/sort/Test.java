package com.ncst1.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Date 2020/9/12 9:09
 * @Author by LiShiYan
 * @Descaption
 */
public class Test {
    final static int count = 100000;
   // final static int[] arr = new int[]{1, 4, 2, 7, 9, 8, 3, 6};
    final static int[] arr = new int[]{1, 4, 2, 7};
    //final static int[] arr = creat();

    public static void main(String[] args) {
        //testBubbleSort();
        // testQuickSort();
        //testInsertSort();
        // testSelectSort();
        //testShellSort();
        //testMergeSort();
        testHeapSort();
    }

    static void testHeapSort() {
        HeapSort heapSort = new HeapSort();
        int[] sort = heapSort.sort(arr);
        print(sort);
    }

    static void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        int[] sort = mergeSort.sort(arr);
        print(sort);
    }

    static void testShellSort() {
        ShellSort shellSort = new ShellSort();
        int[] sort = shellSort.sort(arr);
        print(sort);
    }

    static void testSelectSort() {
        SelectSort selectSort = new SelectSort();
        int[] sort = selectSort.sort(arr);
        print(sort);
    }

    static void testInsertSort() {
        InsertSort insertSort = new InsertSort();
        int[] sort = insertSort.sort(arr);
        print(sort);

    }

    static void testQuickSort() {
        QuickSort quickSort = new QuickSort();
        print(quickSort.sort(creat()));
    }

    static void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] sort = bubbleSort.sort(creat());
        print(sort);
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     * 创造随机数
     *
     * @return
     */
    public static int[] creat() {
        int[] array = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            array[i] = random.nextInt(count);
        }
        return array;
    }
}
