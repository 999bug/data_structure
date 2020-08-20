package com.edu.tree.avltree;

/**
 * @Date 2020/6/13 9:55
 * @Author by LiShiYan
 * @Description ceshi
 */
public class Test {
    public static void main(String[] args) {
        //int[] arr = {4,3,6,5,7,8};
      //  int[] arr = { 10, 12, 8, 9, 7, 6 };
        int[] arr = { 10, 11, 7, 6, 8, 9 };
        AvlTree avlTree = new AvlTree();
        //添加结点
        for(int i=0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());
    }
}
