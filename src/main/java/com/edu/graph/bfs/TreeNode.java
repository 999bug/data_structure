package com.edu.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Date 2020/6/27 22:43
 * @Author by LiShiYan
 * @Description TODO
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    /**
     * 创建二叉树
     *
     * @param inputlist
     * @return
     */
    public TreeNode createBinaryTree(LinkedList<Integer> inputlist) {
        TreeNode node = null;
        if (inputlist == null || inputlist.isEmpty()) {
            return null;
        }
        Integer data = inputlist.removeFirst();//移除并返回此列表的第一个元素
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputlist);
            node.right = createBinaryTree(inputlist);
        }
        return node;
    }

    /**
     * bfs 按层遍历
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //定义集合临时存放队列的元素
        List<Integer> list = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            //向集合中添加队列的头,并移除
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
