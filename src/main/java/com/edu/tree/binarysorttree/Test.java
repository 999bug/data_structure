package com.edu.tree.binarysorttree;

/**
 * @Date 2020/6/11 9:10
 * @Author by LiShiYan
 * @Description 测试排序二叉树
 */
public class Test {
    public static void main(String[] args) {
        BinarySortTree binarySortTree=new BinarySortTree();
        int[] arr = {7, 3, 10, 12, 5, 1, 9,2};

        //循环的添加结点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12

        //测试一下删除叶子结点


        binarySortTree.delNode(12);


        binarySortTree.delNode(5);
        binarySortTree.delNode(10);
        binarySortTree.delNode(2);
        binarySortTree.delNode(3);

        binarySortTree.delNode(9);
        binarySortTree.delNode(1);
        binarySortTree.delNode(7);
        System.out.println("删除元素后中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12
    }


}
