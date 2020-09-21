package com.ncst1.tree.test;

import com.ncst1.tree.RBTree;
import com.ncst1.tree.printer.BinaryTrees;

/**
 * @Date 2020/8/30 21:29
 * @Author by LiShiYan
 * @Descaption 测试红黑树
 */
public class TestRBTree {
    public static void main(String[] args) {
        test4();
    }

    static void test3() {
        Integer[] data = new Integer[]{
                55, 46, 80, 76, 88, 72, 78
        };
        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        for (int i = 0; i < data.length; i++) {
		//	rb.remove(]);
			System.out.println("---------------------------------------");
			System.out.println("【" + data[i] + "】");
			BinaryTrees.println(rb);
		}
        BinaryTrees.println(rb);
    }

    static void test4() {
        Integer[] data = new Integer[] {
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };

        RBTree<Integer> rb = new RBTree<>();
        for (Integer datum : data) {
            rb.add(datum);
        }

        BinaryTrees.println(rb);

        for (Integer datum : data) {
            rb.remove(datum);
            System.out.println("---------------------------------------");
            System.out.println("【" + datum + "】");
            BinaryTrees.println(rb);
        }
    }
}
