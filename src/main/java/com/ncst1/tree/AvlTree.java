package com.ncst1.tree;


import java.util.Comparator;

/**
 * @Date 2020/8/28 19:49
 * @Author by LiShiYan
 * @Descaption AVL 平衡二叉树
 */
public class AvlTree<E> extends BBST<E> {

    public AvlTree(Comparator<E> comparator) {
        super(comparator);
    }

    public AvlTree() {
        this(null);
    }

    /**
     * 恢复平衡
     *
     * @param grand 高度最低的那个不平衡结点
     */
    private void reBalance(Node<E> grand) {
        Node<E> parent = ((AvlTree.AvlNode<E>) grand).tallerChild();
        Node<E> node = ((AvlTree.AvlNode<E>) parent).tallerChild();
        if (parent.isLeftChild()) {
            //L
            if (node.isLeftChild()) {
                //LL
                rotateRight(grand);
            } else {
                //LR
                rotateLeft(parent);
                rotateRight(grand);
            }
        } else {
            //R
            if (node.isLeftChild()) {
                //RL
                rotateRight(parent);
                rotateLeft(grand);

            } else {
                //RR
                rotateLeft(grand);
            }
        }

    }
    @Override
    protected void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                updateHeight(node);
            } else {
                reBalance(node);
                break;
            }
        }
    }

    @Override
    protected void afterRemove(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                updateHeight(node);
            } else {
                reBalance(node);
            }
        }
    }

    @Override
    protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        super.afterRotate(grand, parent, child);
        //更新高度
        updateHeight(grand);
        updateHeight(parent);
    }

    @Override
    protected void rotate(Node<E> r, Node<E> b, Node<E> c, Node<E> d, Node<E> e, Node<E> f) {
        super.rotate(r, b, c, d, e, f);
        updateHeight(b);
        updateHeight(f);
        updateHeight(d);
    }

    private boolean isBalanced(Node<E> node) {
        return Math.abs(((AvlNode<E>) node).balanceFactor()) <= 1;
    }

    private void updateHeight(Node<E> node) {
        ((AvlNode<E>) node).updateHeight();
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AvlNode<>(element, parent);
    }

    protected static class AvlNode<E> extends Node<E> {
        int height = 1;

        public AvlNode(E element, Node<E> parent) {
            super(element, parent);
        }

        /**
         * 平衡因子
         *
         * @return
         */
        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AvlNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AvlNode<E>) right).height;
            return leftHeight - rightHeight;
        }

        /**
         * 更新高度
         */
        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AvlNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AvlNode<E>) right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }

        /**
         * 最高的孩子结点
         *
         * @return
         */
        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AvlNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AvlNode<E>) right).height;
            if (leftHeight > rightHeight) {
                return left;
            }
            if (leftHeight < rightHeight) {
                return right;
            }

            //leftHeight==rightHeight
            return isLeftChild() ? left : right;
        }

        @Override
        public String toString() {
            String parentString = "null";
            if (parent != null) {
                parentString = parent.element.toString();
            }
            return element + "_p(" + parentString + ")_h(" + height + ")";
        }

    }
}
