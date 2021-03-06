package com.ncst1.tree.test;

import com.ncst1.tree.BST;
import com.ncst1.tree.Visitor;
import com.ncst1.tree.comparator.PersonCmpForAge;
import com.ncst1.tree.file.Files;
import com.ncst1.tree.pojo.Person;
import com.ncst1.tree.printer.BinaryTrees;

/*
 * @Date 2020/8/24 22:39
 * @Author by LiShiYan
 * @Descaption
 */

public class TestBST {

    public static void main(String[] args) {
        test8();
    }


    static void test8() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BST<Integer> bst = new BST<>();
        for (Integer datum : data) {
            bst.add(datum);
        }
        BinaryTrees.println(bst);
        bst.remove(7);
        // bst.remove(8);
        System.out.println("=================================");
        BinaryTrees.println(bst);
    }

    static void test7() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5
        };

        BST<Integer> bst = new BST<>();
        for (Integer datum : data) {
            bst.add(datum);
        }
        BinaryTrees.println(bst);
        System.out.println(bst.isComplete());
    }

    static void test6() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BST<Integer> bst = new BST<>();
        for (Integer datum : data) {
            bst.add(datum);
        }
        BinaryTrees.println(bst);
        System.out.println(bst.heightForLevelOrder());
    }

    static void test5() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BST<Integer> bst = new BST<>();
        for (Integer datum : data) {
            bst.add(datum);
        }
        System.out.println(bst);
        System.out.println("============");
        BinaryTrees.println(bst);
        bst.preOrder(new Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(" " + element);
                return false;
            }
        });
        System.out.println();
    }

    /**
     * 测试前中后序遍历
     */

    static void test4() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 1
        };

        BST<Integer> bst = new BST<>();
        for (Integer datum : data) {
            bst.add(datum);
        }
        BinaryTrees.println(bst);

        bst.preOrder(new Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(" " + element);
                return false;
            }
        });
        System.out.println();

        bst.postOrder(new Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(" " + element);
                return false;
            }
        });
        System.out.println();

        bst.inOrder(new Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(" " + element);
                return false;
            }
        });
        System.out.println();
        bst.levelOrder(new Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(" " + element);
                return false;
            }
        });
        System.out.println();
    }


    static void test9() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BST<Integer> bst = new BST<>();
        for (Integer datum : data) {
            bst.add(datum);
        }
        BinaryTrees.println(bst);

        bst.preOrder(new Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 2 ? true : false;
            }
        });
        System.out.println();

        bst.inOrder(new Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 1 ? true : false;
            }
        });
        System.out.println();

        bst.postOrder(new Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 1 ? true : false;
            }
        });
        System.out.println();

    }

    /*
     * 测试把输出结果保存到本地
     */
    static void test2() {
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 40; i++) {
            bst.add((int) (Math.random() * 100));
        }

        String str = BinaryTrees.printString(bst);
        str += "\n";
        Files.writeToFile("E:/1.txt", str, true);

        // BinaryTrees.println(bst);
    }

    static void test1() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };
        BST<Integer> bst = new BST<>();
        for (Integer datum : data) {
            bst.add(datum);
        }

        BST<Person> bst3 = new BST<>(new PersonCmpForAge());
        bst3.add(new Person(16, "张三"));
        bst3.add(new Person(18, "李四"));
        BinaryTrees.println(bst, BinaryTrees.PrintStyle.INORDER);
    }
}
