package com.edu.tree;

/**
 * @Date 2020/6/6 22:17
 * @Author by LiShiYan
 * @Description 顺序存储二叉树
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        //创建一个 ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.postOrder();
    }
    static class ArrBinaryTree {
        /**
         * 存储数据节点的数组
         */
        private int[] arr;

        public ArrBinaryTree(int[] arr) {
            this.arr = arr;
        }

        /**
         * 重载前序遍历
         */
        public void preOrder(){
            this.preOrder(0);
        }
        /**
         * 重载中序遍历
         */
        public void infixOrder(){
            this.infixOrder(0);
        }
        /**
         * 重载后序遍历
         */
        public void postOrder(){
            this.postOrder(0);
        }
        /**
         * 顺序存储二叉树的前序遍历
         * @param index 数组下标
         */
        public void preOrder(int index){
            if (arr==null||arr.length==0){
                System.out.println("数组为空，不能按照二叉树的前序遍历");
            }
            //输出当前节点
            System.out.println(arr[index]);

            //向左递归遍历
            if ((index*2+1)<arr.length){
                preOrder(2*index+1);
            }
            //向右递归遍历
            if ((index*2+2)<arr.length){
                preOrder(2*index+2);
            }
        }

        /**
         * 顺序存储二叉树的中序遍历
         * @param index 数组下标
         */
        public void infixOrder(int index){
            if (arr==null||arr.length==0){
                System.out.println("数组为空，不能按照二叉树的前序遍历");
            }

            //向左递归遍历
            if ((index*2+1)<arr.length){
                infixOrder(2*index+1);
            }
            //输出当前节点
            System.out.println(arr[index]);
            //向右递归遍历
            if ((index*2+2)<arr.length){
                infixOrder(2*index+2);
            }
        }

        /**
         * 顺序存储二叉树的后序遍历
         * @param index 数组下标
         */
        public void postOrder(int index){
            if (arr==null||arr.length==0){
                System.out.println("数组为空，不能按照二叉树的前序遍历");
            }

            //向左递归遍历
            if ((index*2+1)<arr.length){
                postOrder(2*index+1);
            }

            //向右递归遍历
            if ((index*2+2)<arr.length){
                postOrder(2*index+2);
            }
            //输出当前节点
            System.out.println(arr[index]);
        }
    }
}
