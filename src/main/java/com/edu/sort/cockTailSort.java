package com.edu.sort;

import java.util.Arrays;

public class cockTailSort {
    public static void sort(int[] array){
        int tmp=0;
        for (int i = 0; i <array.length/2 ; i++) {
            //有序标记
            boolean isSorted=true;
            //奇数轮，从左向右比较和交换
            for (int j = i; j <array.length-1 ; j++) {
                if(array[j] > array[j+1])
                {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted)
                break;
            //偶数轮，从右向左比较和交换
            for (int j = array.length-1-i; j >i ; j--) {
                if(array[j] < array[j-1])
                {
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }
    public static int[] creat(){
        int[]array=new int[10000];
        for (int i = 0; i <9999 ; i++) {
            array[i]=i+1;
        }
        array[9999]=1;
        return array;
    }



    public static void main(String[] args) {
        int[] creat = creat();
        long sta = System.currentTimeMillis();
        sort(creat);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(creat));
        System.out.println(end-sta+"time");
    }
}
