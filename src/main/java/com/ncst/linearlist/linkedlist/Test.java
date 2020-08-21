package com.ncst.linearlist.linkedlist;

import com.ncst.linearlist.MyList;

import java.util.List;

/**
 * @Date 2020/8/21 11:10
 * @Author by LiShiYan
 * @Descaption
 */
public class Test {
    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(0);
        boolean contains = list.contains(30);
        System.out.println("contains = " + contains);
        System.out.println(list.toString());

    }
}
