package com.edu.Recursion;

public class RecursionTest {
    public static void test(int n){
        if(n>2){
            test(n-1);
        }
        System.out.println("n="+n);
    }

    public static void main(String[] args) {
        test(4);
    }
}
