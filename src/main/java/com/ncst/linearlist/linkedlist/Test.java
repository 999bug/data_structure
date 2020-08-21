package com.ncst.linearlist.linkedlist;

import com.ncst.linearlist.MyList;
import com.ncst.linearlist.array.MyArrayList;

/**
 * @Date 2020/8/21 11:10
 * @Author by LiShiYan
 * @Descaption
 */
public class Test {
    public static void main(String[] args) {
        /*MyList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(0);
        boolean contains = list.contains(30);
        System.out.println("contains = " + contains);
        System.out.println(list.toString());*/

        MyList<Integer> list = new MyArrayList<>();
       // testList(list);
      //  testList(new MyLinkedList<>());
        testList(new MySingleLinkedList<>());
    }

    static void testList(MyList<Integer> list) {
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]

        list.remove(0); // [11, 66, 22, 33, 44, 77]
        list.remove(2); // [11, 66, 33, 44, 77]
        list.remove(list.size() - 1); // [11, 66, 33, 44]


        System.out.println(list);
    }
}
