package com.offer.tree;

import com.offer.base.BaseTreeUtils;
import com.offer.base.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @Author: Lisy
 * @Date: 2022/08/16/10:36
 * @Description: 从上到下打印二叉树
 */
public class LevelPrintTree extends BaseTreeUtils {

    public static void main(String[] args) {
        TreeNode treeNode = intArrayToTreeNode(new int[]{4, 2, 7, 1, 3, 6, 9});
        levelPrintTree(treeNode);
    }

    private static void levelPrintTree(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (Objects.nonNull(node.left)) {
                queue.offer(node.left);
            }
            if (Objects.nonNull(node.right)) {
                queue.offer(node.right);
            }
        }
    }

}
