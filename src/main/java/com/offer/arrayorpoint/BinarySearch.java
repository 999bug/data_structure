package com.offer.arrayorpoint;

/**
 * @Author: Lisy
 * @Date: 2022/09/05/9:44
 * @Description: 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int i = new BinarySearch().binarySearch(array, 6);
        System.out.println("i = " + i);
    }

    public int binarySearch(int[] array, int num) {
        int low = 0, high = array.length - 1, middle = 0;
        while (low <= high) {
            middle = (low + high) >> 1;
            if (array[middle] > num) {
                low = num + 1;
            } else if (array[middle] < num) {
                high = num - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
