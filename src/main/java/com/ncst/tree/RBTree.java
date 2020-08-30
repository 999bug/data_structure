package com.ncst.tree;

import java.util.Comparator;

/**
 * @Date 2020/8/30 19:36
 * @Author by LiShiYan
 * @Descaption 红黑树
 */
public class RBTree<E> extends BBST<E> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RBTree() {
        this(null);
    }

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;

        //添加的是根节点 或者上溢到达了根节点
        if (parent == null) {
            black(node);
            return;
        }
        //如果父节点是黑色 ，直接返回
        if (isBlack(parent)) {
            return;
        }

        //叔父结点
        Node<E> uncle = parent.sibling();
        //祖父节点, 规定新添加的结点是 红色
        Node<E> grand = red(parent.parent);

        //叔父结点是红色【B树结点上溢】
        if (isRed(uncle)) {
            black(parent);
            black(uncle);
            //把祖父结点当作是新添加的结点
            afterAdd(grand);
            return;
        }

        //叔父结点不是红色
        if (parent.isLeftChild()) {
            //L
            if (node.isLeftChild()) {
                //LL
                black(parent);
                //red(grand);
            } else {
                //LR
                black(node);
                rotateLeft(parent);
            }
            rotateRight(grand);
        } else {
            //R
            if (node.isLeftChild()) {
                //RL
                black(node);
                rotateRight(parent);
            } else {
                // RR
                black(parent);
            }
            rotateLeft(grand);
        }

    }

    /**
     * 上色
     *
     * @param node  结点
     * @param color 颜色
     * @return 上色的该节点
     */
    private Node<E> color(Node<E> node, boolean color) {
        if (node == null) {
            return node;
        }
        ((RBNode<E>) node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node) {
        return color(node, RED);
    }

    private Node<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    /**
     * @param node null树 默认为黑色
     * @return 判断颜色是什么
     */
    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RBNode<E>) node).color;
    }

    /**
     * @param node 结点
     * @return 返回此结点是否为红子树
     */
    private boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }

    /**
     * @param node 结点
     * @return 返回此结点是否为黑子树
     */
    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RBNode<>(element, parent);
    }

    private static class RBNode<E> extends Node<E> {
        boolean color = RED;

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str = "";
            if (color == RED) {
                str = "R_";
            }
            return str + element.toString();
        }
    }
}
