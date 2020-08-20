package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Date 2020/5/20 13:48
 * @Author by hp
 */
public class demo1352 {
    public static void main(String[] args) {
        demo1352 demo1352=new demo1352();
        demo1352.add(5);
        demo1352.add(2);
        demo1352.add(3);
        int product = demo1352.getProduct(3);
        System.out.println(product);
    }
    private List<Integer> list;

    public demo1352() {

        list=new ArrayList<>();
        list.add(-1);
        list.clear();
    }

    public void add(int num) {

        list.add(num);

    }

    public int getProduct(int k) {
        int num=1;
        for(int i=0;i<k;i++){
            num*=list.get(list.size()-k++);
        }
        return num;
    }


}
