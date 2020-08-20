package com.edu.sort;

import java.util.Random;

public class BubbleSort {
    public  void sort1(int[] array) {
        int temp = 0;
        for (int i = 0; i <array.length-1; i++) {
            //有序标记
            boolean isSorted=true;
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    //有元素所以不是有序
                    isSorted =false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }



    public  void sort(int[] array) {
        int temp = 0;
            //记录最后一次交换的位置
            int lastExchangeIndex=0;
            //无序数列的边界，每次比较只需要比到这里为止
            int sorrtBorder=array.length-1;
        for (int i = 0; i <array.length; i++) {
            //有序标记
            boolean isSorted=true;
            for (int j = 0; j < sorrtBorder; j++) {
                if (array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    //有元素所以不是有序
                    isSorted =false;
                    //把无序数列的边界更新为最后一次元素交换的位置
                    lastExchangeIndex=j;
                }
            }
            sorrtBorder=lastExchangeIndex;
            if(isSorted){
                break;
            }
        }
    }

    /**
     * 输出排序
     * @param array
     */
    public   void showSort(int[] array){
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 创造随机数
     * @return
     */
    public  int[] creat(){
        int[] array=new int[count];

        Random random=new Random();

        for (int i = 0; i <count ; i++) {
            if(i<count/2)
            { array[i]=random.nextInt(count/2);}
            if (i>=count/2){
                array[i]=i;}
        }
        return array;
    }
public static int count=10000;

   /* public static void main(String[] args) {
        int[] array=new int[count];
        array=creat();
        int[] a=array.clone();
        int[] b=array.clone();

        long sta = System.currentTimeMillis();
        sort1(a);
        long end = System.currentTimeMillis();
       // showSort(array);
        System.out.printf("sort1  "+(end-sta));

        long sta1 = System.currentTimeMillis();
        sort(b);
        long end1 = System.currentTimeMillis();
        // showSort(array);
        System.out.printf("sort"+(end1-sta1));
    }*/

}
