package com.edu.tree.binarysorttree;

/**
 * @Date 2020/6/11 8:54
 * @Author by LiShiYan
 * @Description 二叉排序树结点
 * 二叉排序树：BST: (Binary Sort(Search) Tree)
 * 1.对于二叉排序树的任何一个 非叶子 节点，
 * 2.要求 左子节点的值 比当前节点的值小
 * 3.右子节点的值比当前节点的值大。
 */
public class Node {
    private Integer data;
    private Node left;
    private Node right;

    public Node(Integer data) {
        this.data = data;
    }

    /**
     * 查找要删除结点的父结点
     * @param data 删除结点
     * @return 删除结点的父结点， 如果没有返回null
     */
    public Node searchParent(int data) {
        //如果当前结点是删除结点的父节点，返回true
        boolean isParent = (this.left != null && this.left.data == data) || (this.right != null && this.right.data == data);
        if (isParent) {
            //返回当前结点
            return this;
        } else {
            //如果查找的值小于当前结点的值，并且当前结点的左子结点不为空
            if (data < this.data && this.left != null) {
                //向左子树递归
                return this.left.searchParent(data);
            } else if (data >= this.data && this.right != null) {
                //向右子树递归
                return this.right.searchParent(data);
            } else {
                //没有找到父结点
                return null;
            }
        }
    }

    /**
     * 查找要删除的结点
     *
     * @param data 要删除结点的值
     * @return 如果找到返回该结点，否则返回null
     */
    public Node search(int data) {
        //找到该结点
        if (data == this.data) {
            return this;
        }
        //如果查找的值小于当前结点，向左子树递归查找
        else if (data < this.data) {
            //如果左子树为空，返回null
            if (this.left == null) {
                return null;
            }
            return this.left.search(data);
        }
        //如果查找的值大于等于当前结点，向右子树递归查找
        else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(data);
        }
    }

    /**
     * 递归的形式添加节点
     *
     * @param node 要添加的结点
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入结点的值和当前子树的根节点的值的关系
        //1.添加结点的值小于当前结点的值
        if (node.data < this.data) {
            if (this.left == null) {
                //当前结点的left指针指向node结点
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else {
            //2.添加的结点值大于 当前结点的值
            if (this.right == null) {
                //当前结点的right指针指向node结点
                this.right = node;
            } else {
                //递归向右子树添加
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
