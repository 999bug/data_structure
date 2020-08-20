package com.edu.tree.avltree;

/**
 * @Date 2020/6/13 9:28
 * @Author by LiShiYan
 * @Description 平衡二叉树
 */
public class AvlTree {
    private Node root;

    public Node getRoot() {
        return root;
    }


    /**
     * 1. 返回的 以node 为根结点的二叉排序树的最小结点的值
     * 2. 删除node 为根结点的二叉排序树的最小结点
     *
     * @param node 传入的结点（当做二叉排序树的根节点）
     * @return 以node为根节点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node targetNode = node;
        //循环的查找左子结点，就会找到最小值
        while (targetNode.getLeft() != null) {
            targetNode = targetNode.getLeft();
        }
        //循环结束，此时target指向了最小的结点
        //删除最小结点
        delNode(targetNode.getData());

        return targetNode.getData();
    }

    /**
     * @param data 要删除结点
     */
    public void delNode(int data) {
        if (root == null) {
            return;
        } else {
            //1.找到要删除结点
            Node targetNode = search(data);
            //如果没有找到要删除的结点，返回
            if (targetNode == null) {
                return;
            }
            //如果当前这颗二叉排序树只有一个结点
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }
            //2.找到targetNode父结点
            Node parent = searchParent(data);
            //3.1如果删除的结点是叶子结点
            if (targetNode.getLeft() == null && targetNode.getRight() == null) {
                //判断targetNode是父结点的左子结点还是右子结点
                if (parent.getLeft() != null && parent.getLeft().getData() == data) {
                    //左子结点
                    parent.setLeft(null);
                }
                if (parent.getRight() != null && parent.getRight().getData() == data) {
                    //右子结点
                    parent.setRight(null);
                }
            }
            //3.2 删除有两颗子树的节点
            else if (targetNode.getLeft() != null && targetNode.getRight() != null) {
                //1.找到最小结点
                int minValue = delRightTreeMin(targetNode.getRight());
                //2.设置删除结点的值为最小结点的值
                targetNode.setData(minValue);
            }
            //3.3 删除只有一颗子树的结点
            else {
                //1.如果要删除的结点有 左子结点: targetNode.getLeft()
                if (targetNode.getLeft() != null) {
                    //父结点不为空
                    if (parent != null) {
                        //1.2如果targetNode是 parent 左子结点
                        if (parent.getLeft().getData() == data) {
                            //将parent 左结点指针 指向targetNode的左子结点
                            parent.setLeft(targetNode.getLeft());
                        } else {
                            //1.3如果targetNode是 parent 右子结点
                            parent.setRight(targetNode.getLeft());
                        }
                    } else {
                        //父结点为空，让目标结点的左节点成为根结点
                        root = targetNode.getLeft();
                    }
                } else {
                    //2. 如果要删除的结点有 右子结点: targetNode.getRight()
                    if (parent != null) {
                        //2.2如果targetNode是 parent 左子结点
                        if (parent.getLeft().getData() == data) {
                            parent.setLeft(targetNode.getRight());
                        } else {
                            //2.3如果targetNode是 parent 右子结点
                            parent.setRight(targetNode.getRight());
                        }
                    } else {
                        //父结点为空，让目标结点的右节点成为根结点
                        root = targetNode.getRight();
                    }
                }
            }
        }
    }

    /**
     * 查找要删除的结点
     *
     * @param data 要删除结点
     * @return 以删除结点
     */
    public Node search(int data) {
        if (root == null) {
            return null;
        } else {
            return root.search(data);
        }
    }

    /**
     * 查找父结点
     *
     * @param data 要删除结点
     * @return 要删除结点的父结点
     */
    public Node searchParent(int data) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(data);
        }
    }

    /**
     * 添加结点
     *
     * @param node 结点
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }
}
