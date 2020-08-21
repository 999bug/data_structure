package com.edu.school;

import java.util.Arrays;

/**
 * @Date 2020/4/5 19:38
 * @Author hp
 * 用两种方法实现顺序存储结构线性表中满足k1<=e<=k2数据元素的删除操作。
 */
public class ArrayDemo {

    public static void main(String[] args) {
        int[] array =new int[]{5,6,8,9,45,22,39,15,55,74};
        int[] remove = remove1(6, 22, array);
        System.out.println(Arrays.toString(remove));
    }

    /**
     * 第一种方法
     * @param k1 最小值
     * @param k2 最大值
     * @param arr 需要执行删除操作的数组
     * @return 执行完删除操作的数组
     */
    public static int[] remove(int k1,int k2,int[]arr){
        if (arr.length<=0||arr==null||k1<0||k2<0){
            throw new RuntimeException("请输入正确的格式");
        }

        int[] newArr =new int[arr.length];

        int k=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=k1&&arr[i]<=k2){
               continue;//跳出本次循环进行下一次循环
            }
            newArr[k++]=arr[i];
        }
        return newArr;
    }
    /**
     * 第二种方法
     * @param k1 最小值
     * @param k2 最大值
     * @param arr 需要执行删除操作的数组
     * @return 删除的数组元素
     */
    public static int[] remove1(int k1,int k2,int[]arr){
        if (arr.length<=0||arr==null||k1<0||k2<0){
            throw new RuntimeException("请输入正确的格式");
        }

        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <k1 && arr[i] >k2){
                arr[k++] = arr[i];
            }

        }
        int [] newArr = new int[k];
        for (int i = 0; i < k ; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

}
