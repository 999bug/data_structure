package com.test;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Date 2020/7/5 17:12
 * @Author by LiShiYan
 * @Description TODO
 */

public class test {
    public static void main(String[] args) {
        int fib = fib(2);
        System.out.println(fib);
    }

        public static int fib(int n) {
            if(n==0){
                return 0;
            }
            int [] resault=new int[n+1];
            resault[1]=1;
            for(int i=2;i<=n;i++){
                resault[i]=(resault[i-1]+resault[i-2])%1000000007;
            }
            return resault[n];
        }

}


