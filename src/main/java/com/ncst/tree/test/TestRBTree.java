package com.ncst.tree.test;

import com.ncst.tree.RBTree;
import com.ncst.tree.printer.BinaryTrees;

/**
 * @Date 2020/8/30 21:29
 * @Author by LiShiYan
 * @Descaption 测试红黑树
 */
public class TestRBTree {
    public static void main(String[] args) {
        test3();
    }

    static void test3() {
        Integer[] data = new Integer[]{
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };
        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);
    }
}
