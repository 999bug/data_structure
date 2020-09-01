package com.ncst.set.tree;

import com.ncst.tree.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Date 2020/8/24 22:14
 * @Author by LiShiYan
 * @Descaption 二叉树
 */
public class BinaryTree<E>  {
    protected int size;
    protected Node<E> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }


    /**
     * 前序遍历
     *
     * @param visitor 要以什么形式显示结果
     */
    public void preOrder(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        preOrder(root, visitor);
    }


    private void preOrder(Node<E> node, Visitor<E> visitor) {
        //递归结束条件
        if (node == null || visitor.stop) {
            return;
        }

        visitor.stop = visitor.visit(node.element);
        preOrder(node.left, visitor);
        preOrder(node.right, visitor);
    }

    /**
     * 中序遍历
     *
     * @param visitor 要以什么形式显示结果
     */
    public void inOrder(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        inOrder(root, visitor);
    }

    private void inOrder(Node<E> node, Visitor<E> visitor) {
        //递归结束条件
        if (node == null || visitor.stop) {
            return;
        }

        preOrder(node.left, visitor);
        //此处的visitor.stop 控制打印结束
        if (visitor.stop) {
            return;
        }
        visitor.stop = visitor.visit(node.element);
        preOrder(node.right, visitor);
    }

    /**
     * 后序遍历
     *
     * @param visitor 要以什么形式显示结果
     */
    public void postOrder(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        postOrder(root, visitor);
    }

    private void postOrder(Node<E> node, Visitor<E> visitor) {
        //递归结束条件
        if (node == null || visitor.stop) {
            return;
        }

        preOrder(node.left, visitor);
        preOrder(node.right, visitor);
        //此处的visitor.stop 控制打印结束
        if (visitor.stop) {
            return;
        }
        visitor.stop = visitor.visit(node.element);
    }

    /**
     * 层序遍历
     *
     * @param visitor
     */
    public void levelOrder(Visitor<E> visitor) {
        if (root == null || visitor == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            if (visitor.visit(poll.element)) {
                return;
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }

            if (poll.left != null) {
                queue.offer(poll.left);
            }
        }
    }

    /**
     * 使用层序遍历判断树是否为完全二叉树
     *
     * @return
     */
    public boolean isComplete() {
        if (root == null) {
            return false;
        }

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();

            //如果接下来的是叶子结点，但是遍历到该节点不是叶子结点，返回false
            if (leaf && !node.isLeaf()) {
                return false;
            }

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {
                //表示剩下的全是叶子结点
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 使用层序遍历求树的高度
     *
     * @return
     */
    public int heightForLevelOrder() {
        if (root == null) {
            return 0;
        }
        //每层结点的数量，
        int levelCount = 1;
        int height = 0;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelCount--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelCount == 0) {
                //每层节点的数量等于队列的大小
                levelCount = queue.size();
                height++;
            }
        }
        return height;
    }

    /**
     * 使用递归计算树的高度
     *
     * @return
     */
    public int heightForRecursion() {
        return heightForRecursion(root);
    }

    private int heightForRecursion(Node<E> node) {
        if (node == null) {
            return 0;
        }
        int a = heightForRecursion(node.left);
        int b = heightForRecursion(node.right);
        return 1 + Math.max(a, b);
    }

    protected Node<E> createNode(E element, Node<E> parent) {
        return new Node<>(element, parent);
    }

    /**
     * 前驱节点
     *
     * @param node
     * @return
     */
    protected Node<E> predecessor(Node<E> node) {
        if (node == null) {
            return null;
        }
        // 前驱节点在左子树当中（left.right.right.right....）
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        // 从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }

        // node.parent == null
        // node == node.parent.right
        return node.parent;
    }

    /**
     * 后继节点
     *
     * @param node
     * @return
     */
    protected Node<E> successor(Node<E> node) {
        if (node == null) {
            return null;
        }

        //后继节点在右子树当中（right.left.left.left...
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        // 从父节点、祖父节点中寻找后继节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }




    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        /**
         * 判断是否是叶子结点
         *
         * @return
         */
        public boolean isLeaf() {
            return left == null && right == null;
        }

        /**
         * 判断度是否为2个
         *
         * @return
         */
        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }

        /**
         * @return 兄弟结点
         */
        public Node<E> sibling() {
            if (isLeftChild()) {
                return parent.right;
            }
            if (isRightChild()) {
                return parent.left;
            }
            //没有兄弟结点
            return null;
        }
    }


}
