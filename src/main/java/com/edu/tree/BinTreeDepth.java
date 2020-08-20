package com.edu.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Date 2020/5/25 16:45
 * @Author by 李石岩
 * @Description 计算二叉树深度
 */
public class BinTreeDepth {

    /**
     * 递归实现 计算二叉树深度
     *
     * @param treeNode 二叉树
     * @return 二叉树深度
     */
    public int getBinTreeDepthRecursion(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        //左子树
        int left = getBinTreeDepthRecursion(treeNode.leftChild);
        //右子树
        int right = getBinTreeDepthRecursion(treeNode.rightChild);
        System.out.println("left=" + left + ", right=" + right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 层序遍历实现计算二叉树深度
     * @param treeNode 二叉树
     * @return 二叉树深度
     */
    public int getBinTreeDepthLevelOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //将指定的元素插入此队列（如果立即可行且不会违反容量限制），
        // 当使用有容量限制的队列时，此方法通常要优于 add(E)，后者可能无法插入元素，而只是抛出一个异常。
        queue.offer(treeNode);
        //记录当前层的个数
        int nextCount = 1;
        int count = 0;
        //记录层数
        int deep = 0;
        while (!queue.isEmpty()) {
            //获取并移除此队列的头，如果此队列为空，则返回 null
            TreeNode node = queue.poll();
            count++;
            if (node.leftChild!= null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
            if (count==nextCount){
                nextCount=queue.size();
                count=0;
                deep++;
            }
        }
        return deep;
    }

    /**
     * 创建二叉树
     * @param inputList  链表
     * @return 二叉树
     */
    public TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        //移除并返回此列表的第一个元素
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild=createBinaryTree(inputList);
            node.rightChild=createBinaryTree(inputList);
        }
        return node;
    }

}
