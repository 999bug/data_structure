package com.offer.tree;

import com.offer.base.BaseTreeUtils;
import com.offer.base.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @Author: Lisy
 * @Date: 2022/09/05/15:18
 * @Description: 求二叉树的深度
 */
public class BinaryTreeDepth extends BaseTreeUtils {

    public static void main(String[] args) {
        TreeNode node = stringToTreeNode(new String[]{"3", "9", "20", "null", "null", "15", "7"});
        int i = new BinaryTreeDepth().maxDepth(node);
        System.out.println("i = " + i);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 思想：利用层序遍历每遍历一层则对深度＋1操作
     * 消耗掉每一层的所有元素在开始下一层的遍历
     */
    public int maxDepthBFS(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            // 消耗掉每一层的所有元素在开始下一层的遍历
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (Objects.nonNull(node)) {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return res;
    }
}
