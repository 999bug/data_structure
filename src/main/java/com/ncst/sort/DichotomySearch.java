package com.ncst.sort;

/**
 * @Date 2020/9/12 16:49
 * @Author by LiShiYan
 * @Descaption 二分查找法
 */
public class DichotomySearch {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i]=i;
        }
        int tar = dichotomySearch(array, 2);
        System.out.println(tar);
    }

    /**
     * 二分查找法
     *
     * @param array
     * @param tar
     * @return 数组下标
     */
    private static int dichotomySearch(int[] array, int tar) {
        int len = array.length;

        int left = 0;
        int right = len - 1;
        int result = -1;
        while (left <= right) {
            //防止整形溢出
            int middle = left+((right-left)>>1);

            if (tar == array[middle]) {
                result = middle;
            }

            if (tar > array[middle]) {
                left = middle + 1;
            } else {
                right = middle-1 ;
            }
        }
        return result;
    }
}
