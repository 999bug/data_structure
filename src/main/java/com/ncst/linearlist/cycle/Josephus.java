package com.ncst.linearlist.cycle;

/**
 * @Date 2020/8/23 21:57
 * @Author by LiShiYan
 * @Descaption 约瑟夫问题
 */
public class Josephus {
    public static void main(String[] args) {
        MyCycleLinkedList<Integer> list=new MyCycleLinkedList<>();
        for (int i = 1; i <= 8; i++) {
            list.add(i);
        }
        list.reset();
        while (!list.isEmpty()){
            list.next();
            list.next();
            //3 6 1 5 2 8 4 7
            System.out.println(list.remove());
        }
    }
}
