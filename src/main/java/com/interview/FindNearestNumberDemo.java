package com.interview;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Date 2020/5/28 8:53
 * @Author by hp
 * @Description 寻找全排列的下一个数
 * 1. 从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界。
 * 2.  让逆序区域的前一位和逆序区域中大于它的最小的数字交换位置。
 * 3. 把原来的逆序区域转为顺序状态
 */
public class FindNearestNumberDemo {
    /**
     * 寻找全排列 的下一个数
     *
     * @param numbers 原数组
     * @return 下一个数
     */
    public int[] findNearestNumber(int[] numbers) {
        //1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(numbers);
        //如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数字组成的整数，返回null
        if (index == 0) {
            return null;
        }


        //2.把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        //复制并入参，避免直接修改入参
        exchangeHead(numbersCopy, index);

        //3.把原来的逆序区域转为顺序
        reverse(numbersCopy, index);
        return numbersCopy;
    }

    /**
     * 顺序排列逆序区域中的数
     * @param num 原数组
     * @param index 当前逆序边界最大数的 数组下标
     * @return 顺序排列完的数组
     */
    private int[] reverse(int[] num, int index) {
        for (int i = index, j = num.length - 1; i < j; i++, j--) {
            int temp =num[i];
            num[i]=num[j];
            num[j]=temp;
        }
        return num;
    }

    /**
     * 让逆序区域的前一位和逆序区域中大于它的最小的数字交换位置。
     *
     * @param numbers  原数组
     * @param index 当前逆序边界最大数的 数组下标
     */
    private int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }

    /**
     * 找到逆序区域的前一位，也就是数字置换的边界
     *
     * @param numbers 数组
     * @return 逆序区域的前一位
     */
    private int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }
}
