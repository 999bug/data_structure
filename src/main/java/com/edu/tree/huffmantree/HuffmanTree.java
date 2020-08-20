package com.edu.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Date 2020/6/10 17:11
 * @Author by LiShiYan
 * @Description 霍夫曼树
 * 构成赫夫曼树的步骤：
 * 	1. 从小到大进行排序, 将每一个数据，每个数据都是一个节点 ， 每个节点可以看成是一颗最简单的二叉树
 * 	2. 取出根节点权值最小的两颗二叉树
 * 	3. 组成一颗新的二叉树, 该新的二叉树的根节点的权值是前面两颗二叉树根节点权值的和
 * 	4. 再将这颗新的二叉树，以根节点的权值大小 再次排序， 不断重复  1-2-3-4 的步骤，直到数列中，所有的数据都被处理，就得到一颗赫夫曼树
 */
public class HuffmanTree {

    /**
     * 前序遍历
     *
     * @param root 遍历对象
     */
    public void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历~~");
        }
    }

    /**
     * 创建赫夫曼树
     *
     * @param arr 待创建赫夫曼数组
     * @return 赫夫曼树的root结点
     */
    public Node createHuffmanTree(int[] arr) {
        //1.将数组每一个元素转换成对象，存入集合中
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        //进行循环，当nodes大小为1时退出循环
        while (nodes.size() > 1) {
            //2.进行排序
            Collections.sort(nodes);

            //3.取出根节点权值最小的两颗二叉树
            //3.1 取出权值最小的结点(二叉树)
            Node leftNode = nodes.get(0);
            //3.2 取出权值第二小的结点(二叉树)
            Node rightNode = nodes.get(1);

            //4.创建一颗新的二叉树
            Node parent = new Node(leftNode.getData() + rightNode.getData());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);

            //5.删除处理过的两颗二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //6.将新构建的二叉树加入到nodes里
            nodes.add(parent);
        }

        //返回赫夫曼树的root结点，也就是第一个结点
        return nodes.get(0);
    }

}
