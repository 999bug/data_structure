package com.edu.tree.threadBinarytree;

/**
 * 线索化二叉树
 */
class ThreadedBinaryTree {
    private HeroNode root;
    /**
     * 创建二叉树数组
     */
    private Integer[] array;

    /**
     * 为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
     * 在递归进行线索化时，pre 总是保留前一个结点
     */
    private HeroNode pre = null;


    public ThreadedBinaryTree(){

    }
    public ThreadedBinaryTree(Integer[] array) {
        this.array=array;
        this.root = createBinaryTree(array, 0);
    }

    /**
     * 重载中序线索化方法
     */
    public void infixThreadedNodes() {
        this.infixThreadedNodes(root);
    }

    /**
     * 重载前序线索化方法
     */
    public void preThreadedNodes() {
        this.preThreadedNodes(root);
    }

    /**
     * 重载后序线索化方法
     */
    public void postThreadedNodes() {

        this.postThreadedNodes(root);
    }

    /**
     * 后序遍历线索化二叉树
     */
    public void postThreadedList() {
        //1、找后序遍历方式开始的节点
        HeroNode node = root;
        //当左节点是子树时，循环到下一个结点
        while (node != null && node.getLeftType() == 0) {
            node = node.getLeft();
        }

        while (node != null) {
            //右结点是线索
            if (node.getRightType() == 1) {
                System.out.println(node);
                pre = node;
                node = node.getRight();
            } else {
                //如果上个处理的节点是当前节点的右节点
                if (node.getRight() == pre) {
                    System.out.println(node);
                    if (node == root) {
                        return;
                    }
                    pre = node;
                    node = node.getParent();
                } else {
                    //如果从左节点的进入则找到有子树的最左节点
                    node = node.getRight();
                    while (node != null && node.getLeftType() == 0) {
                        node = node.getLeft();
                    }
                }
            }
        }
    }

    /**
     * 中序遍历线索化二叉树
     */
    public void infixThreadedList() {
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        while (node != null) {
            //循环的找到leftType == 1的结点，第一个找到就是8结点
            //后面随着遍历而变化,因为当leftType==1时，说明该结点是按照线索化
            //处理后的有效结点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //打印当前这个结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点,就一直输出
            while (node.getRightType() == 1) {
                //获取到当前结点的后继结点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = node.getRight();

        }
    }

    /**
     * 前序遍历线索化二叉树
     */
    public void preThreadedList() {
        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                System.out.println(node);
                node = node.getLeft();
            }
            System.out.println(node);
            node = node.getRight();
        }
    }

    /**
     * 对二叉树进行前序线索化
     *
     * @param node 就是当前需要线索化的结点
     */
    public void preThreadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        //1.先线索化当前结点
        //1.1处理当前结点的前驱节点
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }

        //1.2处理当前结点的后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        //2.线索化左子树
        if (node.getLeftType() == 0) {
            preThreadedNodes(node.getLeft());
        }

        //3.线索化右子树
        if (node.getRightType() == 0) {
            preThreadedNodes(node.getRight());
        }
    }

    /**
     * 对二叉树进行中序线索化
     *
     * @param node 就是当前需要线索化的结点
     */
    public void infixThreadedNodes(HeroNode node) {
        //如果node==null, 不能线索化
        if (node == null) {
            return;
        }

        //1.先线索化左子树
        infixThreadedNodes(node.getLeft());

        //2.线索化当前结点
        //2.1处理当前结点的前驱结点
        //以8结点来理解
        //8结点的.left = null , 8结点的.leftType = 1
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //2.2处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        //3.在线索化右子树
        infixThreadedNodes(node.getRight());
    }

    /**
     * 后序线索化
     *
     * @param node
     */
    public void postThreadedNodes(HeroNode node) {

        if (node == null) {
            return;
        }
        //1.线索化左子树
        postThreadedNodes(node.getLeft());
        //2.线索化右子数
        postThreadedNodes(node.getRight());
        //3.线索化结点
        //3.1处理当前结点的前驱结点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

    }


    //删除结点
    public void delNode(int no) {
        if (root != null) {
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除~");
        }
    }

    /**
     * 通过数组构造一个二叉树（完全二叉树）
     *
     * @param array
     * @param index
     * @return
     */
    public HeroNode createBinaryTree(Integer[] array, int index) {
        HeroNode node = null;

        if (index < array.length) {
            node = new HeroNode(array[index]);
            node.setLeft(createBinaryTree(array, index * 2 + 1));
            node.setRight(createBinaryTree(array, index * 2 + 2));

            //记录节点的父节点（后序线索化遍历时使用）
            if (node.getLeft() != null) {
                node.getLeft().setParent(node);
            }

            if (node.getRight() != null) {
                node.getRight().setParent(node);
            }
        }

        return node;
    }
}