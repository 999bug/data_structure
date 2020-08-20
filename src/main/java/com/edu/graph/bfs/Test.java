package com.edu.graph.bfs;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Date 2020/6/27 22:45
 * @Author by LiShiYan
 * @Description TODO
 */
public class Test {
    public static void main(String[] args) {

        TreeNode treeNode=new TreeNode(3);
        LinkedList<Integer> inputlist = new LinkedList<Integer>(
                Arrays.asList(3,9,20,null,null,15,7));
        TreeNode binaryTree = treeNode.createBinaryTree(inputlist);
        int[] ints = treeNode.levelOrder(binaryTree);
        System.out.println(Arrays.toString(ints));
    }
}
