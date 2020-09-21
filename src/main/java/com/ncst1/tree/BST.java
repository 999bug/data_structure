package com.ncst1.tree;

import java.util.Comparator;

/**
 * @Date 2020/8/24 22:14
 * @Author by LiShiYan
 * @Descaption 二叉搜索树
 */
public class BST<E> extends BinaryTree<E> {
    private Comparator<E> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }


    /**
     * 删除结点
     *
     * @param element
     */

    public void remove(E element) {
        remove(node(element));
    }

    private void remove(Node<E> node) {
        if (node == null) {
            return;
        }
        size--;

        //度为2 的结点
        if (node.hasTwoChildren()) {
            //找到后继节点或者前驱节点
            Node<E> s = successor(node);
            //赋值
            node.element = s.element;
            //删除后继结点
            node = s;
        }

        //删除node结点（node的度必然时1 或者0）
        Node<E> replacement = node.left != null ? node.left : node.right;

        //node是度为1 的结点
        if (replacement != null) {
            //更改parent
            replacement.parent = node.parent;
            if (node.parent == null) {
                //node 是度为1 的结点并且是根节点
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;
            } else {
                node.parent.right = replacement;
            }

            // 删除节点之后的处理
            afterRemove(replacement);
        } else if (node.parent == null) {
            //node 是叶子结点并且是根节点
            root = null;

            // 删除节点之后的处理
            afterRemove(node);
        } else {
            //node 是叶子节点，但不是根节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else {
                // node == node.parent.right
                node.parent.right = null;
            }
            // 删除节点之后的处理
            afterRemove(node);
        }
    }

    protected void afterRemove(Node<E> node) { }

    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                //cmp<0
                node = node.left;
            }
        }
        return null;
    }


    public boolean contains(E element) {
        return node(element) != null;
    }


    public void add(E element) {
        elementNotNullCheck(element);

        // 添加第一个节点
        if (root == null) {
            root = createNode(element, null);
            size++;

            // 新添加节点之后的处理
            afterAdd(root);
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
        Node<E> newNode = createNode(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;

        // 新添加节点之后的处理
        afterAdd(newNode);
    }

    protected void afterAdd(Node<E> node) {

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

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not null");
        }
    }

}
