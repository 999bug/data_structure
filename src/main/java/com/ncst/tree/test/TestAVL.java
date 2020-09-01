package com.ncst.tree.test;

import com.ncst.tree.AvlTree;
import com.ncst.tree.BST;
import com.ncst.tree.printer.BinaryTrees;
import com.ncst.utils.Task;
import com.ncst.utils.Times;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/8/28 20:55
 * @Author by LiShiYan
 * @Descaption
 */
public class TestAVL {
    public static void main(String[] args) {
        test4();
    }
    static void test4() {
        Integer[] data = new Integer[]{
                3,9,20,15,7
        };

        AvlTree<Integer> avl = new AvlTree<>();
        for (Integer datum : data) {
            avl.add(datum);
        }
        //BinaryTrees.println(avl);

    }

    static void test3() {
        Integer[] data = new Integer[]{
                16, 72, 10, 82, 45, 27, 41, 47, 66, 98, 20, 100, 2, 36, 30, 5, 31, 6, 92, 77
        };

        AvlTree<Integer> avl = new AvlTree<>();
        for (Integer datum : data) {
            avl.add(datum);
        }
        BinaryTrees.println(avl);
        System.out.println("=========================");
        avl.remove(100);
        BinaryTrees.println(avl);
    }

    static void test2() {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100_0000; i++) {
            data.add((int) (Math.random() * 100_0000));
        }

        BST<Integer> bst = new BST<>();

        Times.test("BST添加时间", new Task() {
            @Override
            public void execute() {
                for (Integer datum : data) {
                    bst.add(datum);
                }
            }
        });

        Times.test("BST查找时间", new Task() {
            @Override
            public void execute() {
                for (Integer datum : data) {
                    bst.contains(datum);
                }
            }
        });

        Times.test("BST删除时间", new Task() {
            @Override
            public void execute() {
                for (Integer datum : data) {
                    bst.remove(datum);
                }
            }
        });


        AvlTree<Integer> avl = new AvlTree<>();
        Times.test("avl添加时间", new Task() {
            @Override
            public void execute() {
                for (Integer datum : data) {
                    avl.add(datum);
                }
            }
        });

        Times.test("avl查找时间", new Task() {
            @Override
            public void execute() {
                for (Integer datum : data) {
                    avl.contains(datum);
                }
            }
        });

        Times.test("avl删除时间", new Task() {
            @Override
            public void execute() {
                for (Integer datum : data) {
                    avl.remove(datum);
                }
            }
        });

    }


    static void test1() {
        Integer[] data = new Integer[]{
                67, 52, 92, 96, 53, 95, 13, 63, 34, 82, 76, 54, 9, 68, 39
        };

        AvlTree<Integer> avl = new AvlTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(avl);
            System.out.println("---------------------------------------");
        }

        for (int i = 0; i < data.length; i++) {
            avl.remove(data[i]);
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(avl);
            System.out.println("---------------------------------------");
        }

        BinaryTrees.println(avl);
    }
}
