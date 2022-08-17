package com.offer.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @Author: Lisy
 * @Date: 2022/08/12/11:01
 * @Description:
 */
public abstract class BaseTreeUtils {

    /**
     * 将整形数组转换成二叉树
     *
     * @param arrays int 数组
     * @return 二叉树
     */
    protected static TreeNode intArrayToTreeNode(int[] arrays) {
        int item = arrays[0];
        TreeNode root = new TreeNode(item);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            if (index == arrays.length) {
                break;
            }

            item = arrays[index++];
            node.left = new TreeNode(item);
            nodeQueue.add(node.left);

            if (index == arrays.length) {
                break;
            }

            item = arrays[index++];
            node.right = new TreeNode(item);
            nodeQueue.add(node.right);
        }
        return root;
    }

    /**
     * 将带有null 的字符串转换成二叉树
     */
    protected static TreeNode stringToTreeNode(String[] parts) {
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!"null".equals(item)) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!"null".equals(item)) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    /**
     * 层序遍历
     */
    protected static void levelPrint(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            if (Objects.nonNull(treeNode)) {
                System.out.print(treeNode.val + " ");
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }
    }

    protected static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printTree(treeNode);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    protected static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        printTree(treeNode);
        inOrder(treeNode.right);
    }

    protected static void afterOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        afterOrder(treeNode.left);
        afterOrder(treeNode.right);
        printTree(treeNode);
    }

    private static void printTree(TreeNode treeNode) {
        System.out.print(treeNode.val + " ");
    }
}
