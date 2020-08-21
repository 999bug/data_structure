package com.edu.tree;

import com.edu.sort.BubbleSort;
import com.edu.sort.QuickSort;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Date 2020/5/25 17:14
 * @Author by hp
 * @Description 测试类
 */
public class Test {
    public static void main(String[] args) {
        String s = null;
        s.replace(" ","2");
      int a=9;
        int i  = Integer.bitCount(a);
        int res=0;
        while(a!=0){

            res+=a&1;
            System.out.println(a&1);
            a>>>=1;
            System.out.println("当前在第几位："+a);
        }

    }

    /**
     * 测试二叉树深度
     */

    public void test1() {
        LinkedList<Integer> inputlist = new LinkedList<Integer>(
                Arrays.asList(3, 2, 9, null, null, 10, null,
                        null, 8, null, 4));
        BinTreeDepth binTreeDepth = new BinTreeDepth();
        TreeNode binaryTree = binTreeDepth.createBinaryTree(inputlist);
        int i = binTreeDepth.getBinTreeDepthLevelOrderTraversal(binaryTree);
        System.out.println("二叉树深度为 = " + i);

    }


    public void TreeNodeTest() {
        //返回一个受指定数组支持的固定大小的列表。（对返回列表的更改会“直接写”到数组。）
        LinkedList<Integer> inputlist = new LinkedList<Integer>(
                Arrays.asList(3, 2, 9, null, null, 10, null,
                        null, 8, null, 4));
        TreeNode tree = new TreeNode();
        TreeNode treeNode = tree.createBinaryTree(inputlist);

        System.out.println("前序遍历");
        tree.preOrderTravel(treeNode);

      /*  System.out.println("中序遍历");
        inOrderTravel(treeNode);
        System.out.println("后序遍历");
        lastOrderTravel(treeNode);
        System.out.println("层序遍历");
        levelOrderTraversal(treeNode);*/
    }


    public void name() {
        //返回一个受指定数组支持的固定大小的列表。（对返回列表的更改会“直接写”到数组。）
        LinkedList<Integer> inputlist = new LinkedList<Integer>(
                Arrays.asList(3, 2, 9, null, null, 10, null,
                        null, 8, null, 4));
        //创建二叉树节点
        TreeNode tree = new TreeNode();
        TreeNode treeNode = tree.createBinaryTree(inputlist);

        //创建二叉树对象
        BinaryTree binaryTree = new BinaryTree(treeNode);


        /*System.out.println("前序遍历");
        binaryTree.preOrder();*/

        //System.out.println("后序遍历");
        //binaryTree.postOrder();

        // System.out.println("中序遍历");
        //binaryTree.infixOrder();

//        TreeNode treeNode1 = binaryTree.postOrderSearch(4);
//        System.out.println(treeNode1);

        System.out.println("前序遍历");
        binaryTree.preOrder();

//        binaryTree.delNode(2);
//        System.out.println("删除后的");
//        binaryTree.preOrder();


    }


    public void heapSort() {
        int SIZE=8000000;
        int[] arr=new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            // 生成一个[0, SIZE) 数
            arr[i] = (int) (Math.random() * 8000000);
        }

        HeapSort heapSort=new HeapSort();
        long start = System.currentTimeMillis();
        heapSort.heapSort(arr);

        long time = System.currentTimeMillis() - start;
        System.out.println("heapSort所用时"+time);
      //  System.out.println(Arrays.toString(arr));

    }

    public void quickSort() {
        int SIZE=8000000;
        int[] arr=new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            // 生成一个[0, SIZE) 数
            arr[i] = (int) (Math.random() * 8000000);
        }

        long start = System.currentTimeMillis();

        QuickSort quickSort=new QuickSort();
        quickSort.quickSort(arr,0,arr.length-1);
        long time = System.currentTimeMillis() - start;
        System.out.println("quickSort所用时"+time);

      //   System.out.println(Arrays.toString(arr));

    }


    public void BubleSort() {
        int SIZE=8000000;
        int[] arr=new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            // 生成一个[0, SIZE) 数
            arr[i] = (int) (Math.random() * 8000000);
        }

        long start = System.currentTimeMillis();
        BubbleSort bubbleSort=new BubbleSort();
        bubbleSort.sort(arr);

        long time = System.currentTimeMillis() - start;
        System.out.println("BubbleSort所用时"+time);

        //   System.out.println(Arrays.toString(arr));

    }



}
