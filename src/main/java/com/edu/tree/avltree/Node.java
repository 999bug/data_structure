package com.edu.tree.avltree;

/**
 * @Date 2020/6/11 8:54
 * @Author by LiShiYan
 * @Description AVL树结点
 */
public class Node {
    private Integer data;
    private Node left;
    private Node right;

    public Node(Integer data) {
        this.data = data;
    }

    /**
     * @return 返回左子树的高度
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    /**
     * @return 返回右子树的高度
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /**
     * @return 返回 以该结点为根结点的树的高度
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 左旋转
     */
    private void leftRotate() {
        //创建新的结点，以当前根结点的值
        Node newNode = new Node(data);
        //把新的结点的左子树设置成当前结点的左子树
        newNode.left = this.left;
        //把新的结点的右子树设置成带你过去结点的右子树的左子树
        newNode.right = this.right.left;
        //把当前结点的值替换成右子结点的值
        this.data = right.data;
        //把当前结点的右子树设置成当前结点右子树的右子树
        this.right = this.right.right;
        //把当前结点的左子树(左子结点)设置成新的结点
        this.left = newNode;
    }

    /**
     * 左旋转
     */
    private void rightRotate() {
        //创建新的结点，以当前根结点的值
        Node newNode = new Node(data);
        //把新的结点的右子树设置成当前结点的右子树
        newNode.right = this.right;
        //把新的结点的左子树设置成带你过去结点的左子树的右子树
        newNode.left = this.left.right;
        //把当前结点的值替换成左子结点的值
        this.data = this.left.data;
        //把当前结点的左子树设置成当前结点左子树的左子树
        this.left = this.left.left;
        //把当前结点的右子树(右子结点)设置成新的结点
        this.right = newNode;
    }

    /**
     * 查找要删除结点的父结点
     *
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

        //当添加完一个结点后，如果: (右子树的高度-左子树的高度) > 1 , 左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果它的右子树的左子树的高度大于它的右子树的右子树的高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先对右子结点进行右旋转
                right.rightRotate();
                //然后在对当前结点进行左旋转
                leftRotate(); //左旋转..
            } else {
                //直接进行左旋转即可
                leftRotate();
            }
            return; //必须要!!!
        }

        //当添加完一个结点后，如果 (左子树的高度 - 右子树的高度) > 1, 右旋转
        if (leftHeight() - rightHeight() > 1) {
            //如果它的左子树的右子树高度大于它的左子树的高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //先对当前结点的左结点(左子树)->左旋转
                left.leftRotate();
                //再对当前结点进行右旋转
                rightRotate();
            } else {
                //直接进行右旋转即可
                rightRotate();
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
