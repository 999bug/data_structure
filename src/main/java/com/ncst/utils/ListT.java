package com.ncst.utils;

import com.ncst.linearlist.MyList;

/**
 * @Date 2020/8/23 20:56
 * @Author by LiShiYan
 * @Descaption
 */
public  class ListT {
    public static void testList(MyList<Integer> list) {
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
