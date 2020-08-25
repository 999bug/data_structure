package com.ncst.tree;

import com.ncst.tree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Date 2020/8/24 22:14
 * @Author by LiShiYan
 * @Descaption 二叉搜索树
 */
public class BST<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public E remove() {
        return null;
    }

    public boolean contains(E element) {
        return false;
    }

    private Node<E> node(E element) {
        return null;
    }

    public void add(E element) {
        elementNotNullCheck(element);

        // 添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        // 添加的不是第一个节点
        // 找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        do {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 相等
                node.element = element;
                return;
            }
        } while (node != null);

        // 看看插入到父节点的哪个位置
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    /**
     * 返回值等于0，代表e1和e2相等；
     * 返回值大于0，代表e1大于e2；
     * 返回值小于于0，代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
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


    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not null");
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>) node).element;
    }

    /**
     * 自己实现的遍历树形结构
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, "");
        return sb.toString();
    }

    private void toString(Node<E> node, StringBuilder sb, String prefix) {
        if (node == null) {
            return;
        }

        toString(node.left, sb, prefix + "L---");
        sb.append(prefix).append(node.element).append("\n");
        toString(node.right, sb, prefix + "R---");
    }

    public static abstract class Visitor<E> {
        boolean stop;

        public abstract boolean visit(E element);
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
