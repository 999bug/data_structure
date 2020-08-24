package com.ncst.tree;

import com.ncst.tree.comparator.PersonCmpForAge;
import com.ncst.tree.pojo.Person;
import com.ncst.tree.printer.BinaryTrees;

import java.util.Comparator;

/**
 * @Date 2020/8/24 22:39
 * @Author by LiShiYan
 * @Descaption
 */
public class Test {

    public static void main(String[] args) {
test1();
    }

    static  void test1() {

        Integer[] data = new Integer[] {
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
