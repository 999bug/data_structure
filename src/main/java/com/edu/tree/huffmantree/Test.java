package com.edu.tree.huffmantree;

/**
 * @Date 2020/6/10 17:12
 * @Author by LiShiYan
 * @Description 赫夫曼树测试
 */
public class Test {
    @org.junit.Test
    public void Test() {
        int[] arr = { 13, 7, 8, 3, 29, 6, 1 };
        HuffmanTree huffmanTree=new HuffmanTree();
        //前序遍历赫夫曼树
        huffmanTree.preOrder(huffmanTree.createHuffmanTree(arr));
    }
}
