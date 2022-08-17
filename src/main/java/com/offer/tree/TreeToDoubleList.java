package com.offer.tree;

import java.util.Objects;

/**
 * @Author: Lisy
 * @Date: 2022/08/17/15:23
 * @Description: 二叉搜索树转换为双向链表
 */
public class TreeToDoubleList {

    private Node pre, head;

    /**
     * 思路：利用中序遍历和二叉搜索树的特点，逐一遍历节点，设置前后节点
     * 二叉搜索树特点：左子节点小于根节点，右子节点大于根节点
     * 中序遍历特点：左根右
     */
    public Node treeToDoublyList(Node root) {
        if (Objects.isNull(root)) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        dfs(node.left);
        if (Objects.isNull(pre)) {
            head = node;
        } else {
            pre.right = node;
        }

        node.left = pre;
        pre = node;
        dfs(node.right);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this. left = left;
            this. right = right;
        }
    }

}
