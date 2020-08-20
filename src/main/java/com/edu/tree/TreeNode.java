package com.edu.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Date 2020/5/25 16:47
 * @Author by hp
 * @Description 创建TreeNode 结点
 */
public class TreeNode {
    public Integer data;
    /**
     * 左节点默认为空
     */
    public TreeNode leftChild;
    /**
     * 右节点默认为空
     */
    public TreeNode rightChild;

    /**
     * 如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
     */
    public Integer leftType;
    /**
     * 如果rightType == 0 表示指向是右子树, 如果 1表示指向后继结点
     */
    public Integer rightType;

    public TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }

    /**
     * 创建二叉树
     *
     * @param inputlist
     * @return
     */
    public TreeNode createBinaryTree(LinkedList<Integer> inputlist) {
        TreeNode node = null;
        if (inputlist == null || inputlist.isEmpty()) {
            return null;
        }
        Integer data = inputlist.removeFirst();//移除并返回此列表的第一个元素
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputlist);
            node.rightChild = createBinaryTree(inputlist);
        }
        return node;
    }

    /**
     * 递归删除节点
     *
     * @param no 1.如果删除的节点是叶子节点，则删除该节点
     *           2.如果删除的节点是非叶子节点，则删除该子树
     *           思路
     *           1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
     *           2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
     *           3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
     *           4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
     *           5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.
     */
    public void delNode(int no) {
        //1. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        if (this.leftChild != null && this.leftChild.data == no) {
            this.leftChild = null;
            return;
        }
        //2.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if (this.rightChild != null && this.rightChild.data == no) {
            this.rightChild = null;
            return;
        }

        //3.向左子树进行递归删除
        if (this.leftChild != null) {
            this.leftChild.delNode(no);
        }
        //4.向右子树进行递归删除
        if (this.rightChild != null) {
            this.rightChild.delNode(no);
        }
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public void preOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTravel(node.leftChild);
        preOrderTravel(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void inOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTravel(node.leftChild);
        System.out.println(node.data);
        inOrderTravel(node.rightChild);
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void lastOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        lastOrderTravel(node.leftChild);
        lastOrderTravel(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 层序遍历
     *
     * @param root
     */
    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //将指定的元素插入此队列（如果立即可行且不会违反容量限制），
        // 当使用有容量限制的队列时，此方法通常要优于 add(E)，后者可能无法插入元素，而只是抛出一个异常。
        queue.offer(root);
        while (!queue.isEmpty()) {
            //获取并移除此队列的头，如果此队列为空，则返回 null
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }

    }

    /**
     * 前序遍历查找
     *
     * @param data 查找的数据
     */
    public TreeNode preOrderSearch(int data) {
        //1.比较当前节点是不是要找到的值
        if (this.data == data) {
            return this;
        }

        //定义临时变量
        TreeNode curTreeNode = null;
        //2.1判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        //2.2如果左递归前序查找，找到结点，则返回
        if (this.leftChild != null) {
            curTreeNode = this.leftChild.preOrderSearch(data);
        }

        //说明我们左子树找到
        if (curTreeNode != null) {
            return curTreeNode;
        }
        //3.1右递归前序查找，找到结点，则返回，否继续判断，
        //3.2当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if (this.rightChild != null) {
            curTreeNode = this.rightChild.preOrderSearch(data);
        }
        return curTreeNode;
    }

    /**
     * 中序遍历查找
     *
     * @param data 要查找的数据
     * @return 找到的数据
     */
    public TreeNode infixOrderSearch(int data) {
        //1.判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
        TreeNode curTreeNode = null;
        if (this.leftChild != null) {
            curTreeNode = this.leftChild.infixOrderSearch(data);
        }
        //找到左节点返回
        if (curTreeNode != null) {
            return curTreeNode;
        }
        //2.如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
        if (this.data == data) {
            return this;
        }
        //3.否则继续进行右递归的中序查找
        if (this.rightChild != null) {
            curTreeNode = this.rightChild.infixOrderSearch(data);
        }
        return curTreeNode;
    }

    /**
     * 后序遍历查找
     *
     * @param data 要查找的数据
     * @return 找到的数据
     */
    public TreeNode postOrderSearch(int data) {
        TreeNode curTreeNode = null;
        //1.判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
        if (this.leftChild != null) {
            curTreeNode = this.leftChild.postOrderSearch(data);
        }
        //说明在左子树找到
        if (curTreeNode != null) {
            return curTreeNode;
        }

        //2.如果左子树没有找到，则向右子树递归进行后序遍历查找
        if (this.rightChild != null) {
            curTreeNode = this.rightChild.postOrderSearch(data);
        }
        if (curTreeNode != null) {
            return curTreeNode;
        }

        //3.如果左右子树都没有找到，就比较当前结点是不是
        if (this.data == data) {
            return this;
        }
        return curTreeNode;
    }

    /**
     * 计算二叉树深度 递归算法
     *
     * @param root 根节点
     * @return 二叉树深度
     */
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.leftChild);
        int right = treeDepth(root.rightChild);
        return left > right ? left + 1 : right + 1;
    }

}
