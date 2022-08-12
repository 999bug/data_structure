package com.offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * @Author: Lisy
 * @Date: 2022/08/10/15:07
 * @Description: 一个数组中所有的奇数在偶数前面
 */
public class AllOddBeforeEven {

    public static void main(String[] args) {
        int[] array = new int[] {1,4,3,5,2,45,6,43,7,8,10};
        reorderOddEven(array);
        System.out.println(Arrays.toString(array));
    }

    private static void reorderOddEven(int[] array) {
        if (Objects.isNull(array) || array.length == 0) {
            return;
        }

        int left = 0, right = array.length - 1;
        while (left < right) {
            // 向右移动直到遇到偶数
            while (isOdd(array[left]) && left < right) {
                left++;
            }
            // 向左移动直到遇到奇数
            while (!isOdd(array[right]) && left < right) {
                right--;
            }
            // 交换位置
            if (left < right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
    }

    private static boolean isOdd(int param) {
        return (param & 1) == 1;
    }
}
