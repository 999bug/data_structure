package com.offer.tree;

import com.offer.base.BaseUtils;
import com.offer.base.TreeNode;


/**
 * @Author: Lisy
 * @Date: 2022/08/11/16:06
 * @Description: 前中后序遍历二叉树
 */
public class TraverseBinaryTree extends BaseUtils {

    public static void main(String[] args) {
        TreeNode tree = createTree();
        preOrder(tree);
        System.out.println("====");
        inOrder(tree);
        System.out.println("===");
        afterOrder(tree);
    }

    private static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printTree(treeNode);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    private static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        printTree(treeNode);
        inOrder(treeNode.right);
    }

    private static void afterOrder(TreeNode treeNode) {
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
