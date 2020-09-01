package com.leetcode;

import java.util.Arrays;

/**
 * @Date 2020/9/1 20:18
 * @Author by LiShiYan
 * @Descaption 给定一个数组 A[0, 1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 返回除了自己本身的乘积
 https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 */
public class Offer_66_构建乘积数组 {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5};
        int[] ints = Solution.constructArr(a);
        System.out.println(Arrays.toString(ints));
    }

   static class Solution {
        public static int[] constructArr(int[] a) {
            if(a.length == 0) {
                return new int[0];
            }
            int[] b = new int[a.length];
            //?
            b[0] = 1;
            int tmp = 1;

            //计算 B[i] 的 下三角 各元素的乘积，直接乘入 B[i]
            //乘到 size -1 &&a[size-2]结束，因为不乘本身
            for(int i = 1; i < a.length; i++) {
                b[i] = b[i - 1] * a[i - 1];
            }

            //计算上三角的乘积
            for(int i = a.length - 2; i >= 0; i--) {
                tmp *= a[i + 1];
                b[i] *= tmp;
            }
            return b;
        }
    }


}
