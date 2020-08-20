package com.edu.tree;


/**
 * 定义BinaryTree 二叉树
 */
class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode treeNode) {
        this.root = treeNode;
    }


    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrderTravel(root);
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.inOrderTravel(root);
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.lastOrderTravel(root);
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 前序遍历查找
     *
     * @param data 要查找的数据
     * @return 如果为空，未找到，不为空说明找到
     */
    public TreeNode preOrderSearch(int data) {
        if (this.root != null) {
            return this.root.preOrderSearch(data);
        } else {
            return null;
        }
    }

    /**
     * 中序遍历查找
     *
     * @param data 要查找的数据
     * @return 如果为空，未找到，不为空说明找到
     */
    public TreeNode infixOrderSearch(int data) {
        if (this.root != null) {
            return this.root.infixOrderSearch(data);
        } else {
            return null;
        }
    }

    /**
     * 后序遍历查找
     *
     * @param data 要查找的数据
     * @return 如果为空，未找到，不为空说明找到
     */
    public TreeNode postOrderSearch(int data) {
        if (this.root != null) {
            return this.root.postOrderSearch(data);
        } else {
            return null;
        }
    }

    /**
     * 删除节点
     *
     * @param no
     */
    public void delNode(int no) {
        if (this.root != null) {
            if (root.data == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除~");
        }
    }
}


