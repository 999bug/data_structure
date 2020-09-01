package com.leetcode.tree;

/**
 * @Date 2020/9/1 19:36
 * @Author by LiShiYan
 * @Descaption https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */
public class _offer55_平衡二叉树 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        TreeNode tree1 = new TreeNode(9);
        TreeNode tree2 = new TreeNode(20);
        TreeNode tree3 = new TreeNode(15);
        TreeNode tree4 = new TreeNode(7);
        tree.left = tree1;
        tree.right = tree2;
        tree2.left = tree3;
        tree2.right = tree4;
        boolean balanced = Solution.isBalanced(tree);
        System.out.println("balanced = " + balanced);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public static boolean isBalanced(TreeNode root) {
            return recur(root) != -1;
        }

        private static int recur(TreeNode root) {
            if (root == null) return 0;
            int left = recur(root.left);
            if (left == -1) return -1;

            int right = recur(root.right);
            if (right == -1) return -1;
            int a = Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
            return a;
        }
    }
}


