package com.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/5/24 8:58
 * @Author by hp
 * @Description 无序数组最大相邻差
 */
public class UnOrdered_Array_MaxSortedDistance {

    /**
     * 计数排序
     *
     * @param a 未排序数组
     * @return 最大相邻差
     */
    public static int getMaxSortedDistance(int[] a) {

        int min = a[0];
        int max = a[0];

        //1.获取最小值，最大值
        for (int item : a) {
            if (item >= max) {
                max = item;
            }
            if (item <= min) {
                min = item;
            }
        }

        //2.计数排序思想
        int distance = max - min + 1;
        int offset = min;
        //创建一个distance长度的数组，存放 a 数组
        int[] array = new int[distance];
        for (int value : a) {
            //原数组元素的值为n，则将Array[n-min]的值加1
            array[value - min]++;
        }

        // 3.遍历新数组，计算最大相邻差
        //统计空值数量
        int count = 0;
        //最大连续数
        int maxCount = 0;

        //连续的起始位置
        int startIndex = 0;
        //结束的考试位置
        int endIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (count == 0) {
                    //记录连续为0的前一个位置
                    startIndex = i - 1;
                }
                //统计空值，判断0最多连续出现的次数
                count++;
            } else {
                count = 0;
            }
            if (count > maxCount) {
                maxCount = count;
                //记录连续为0的结束位置的最后一个位置
                endIndex = i + 1;
            }

        }
        //4.返回最大相邻差
        return endIndex - startIndex;
    }

    /**
     * 桶排序实现相邻两位最大差值
     *
     * @param a 未排序数组
     * @return  最大相邻差
     */
    public static int getgetMaxSortedDistanceByBucket(int[] a) {
        int min = a[0];
        int max = a[0];

        //1.获取最小值，最大值
        for (int value : a) {
            if (value >= max) {
                max = value;
            }
            if (value <= min) {
                min = value;
            }
        }
        int offset = max - min;
        //如果max=min 说明所有元素都相等
        if (offset == 0) {
            return 0;
        }

        //2.初始化捅
        int bucketNum = a.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        //3.遍历原始数组，确定每个桶的最大最小值
        for (int value : a) {
            //确定数组元素所属的桶下标
            int index = (value - min) * (bucketNum - 1) / offset;
            if (buckets[index].min == null || buckets[index].min > value) {
                buckets[index].min = value;
            }
            if (buckets[index].max == null || buckets[index].max < value) {
                buckets[index].max = value;
            }
        }

        //4.遍历桶，找到最大差值
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax=buckets[i].max;
        }
        return maxDistance;
    }

    static class Bucket {
        private Integer min;
        private Integer max;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 6, 3, 4, 5, 10, 9};
        System.out.println(getgetMaxSortedDistanceByBucket(array));
    }
}
