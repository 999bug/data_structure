package com.ncst1.map.tree;

import java.util.Comparator;

/**
 * @Date 2020/8/30 21:05
 * @Author by LiShiYan
 * @Descaption 平衡二叉搜索树 带有旋转功能
 */
public class BBST<E> extends BST<E> {
    public BBST() {
        this(null);
    }

    public BBST(Comparator<E> comparator) {
        super(comparator);
    }

    protected void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;

        //开始操作
        grand.right = child;
        parent.left = grand;
        afterRotate(grand, parent, child);
    }

    protected void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> child = parent.right;

        //开始操作
        grand.left = child;
        parent.right = grand;
        afterRotate(grand, parent, child);
    }

    protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        //让parent 成为子树的根节点
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else {
            //grand 是root 结点
            root = parent;
        }

        //更新child 的parent
        if (child != null) {
            child.parent = grand;
        }

        //更新grand的 parent
        grand.parent = parent;
    }

}
