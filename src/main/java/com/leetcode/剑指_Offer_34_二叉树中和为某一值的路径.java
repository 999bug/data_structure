package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Date 2020/11/11 22:12
 * @Author by LSY
 * @Description https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class 剑指_Offer_34_二叉树中和为某一值的路径 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node7 = new TreeNode(7);
        root.left = node4;
        root.right = node8;
        node4.left = node11;
        node11.left= node7;
        node11.right= node2;
        node8.left =node13;
        TreeNode newNode4 = new TreeNode(4);
        node8.right= newNode4;
        newNode4.left =node5;
        newNode4.right =node1;

        List<List<Integer>> lists = new 剑指_Offer_34_二叉树中和为某一值的路径().pathSum(root, 22);
        System.out.println(Arrays.deepToString(lists.toArray()));
    }

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        recur(root, sum);
        return res;
    }

    private void recur(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList(path));
        }
        recur(root.left, tar);
        recur(root.right, tar);
        path.remove(path.size() - 1);

    }
}
