package com.offer.tree;

import java.util.Collections;
import java.util.Objects;

/**
 * @Author: Lisy
 * @Date: 2022/08/16/14:35
 * @Description: 给定一个数组判断其是否是二叉搜素树的后序遍历结果
 */
public class VerifyPostOrder {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,5,10,6,9,4,3};
        boolean b = new VerifyPostOrder().verifyPostorder(array);
        System.out.println("b = " + b);
    }

    public boolean verifyPostorder(int[] postorder) {
        if (Objects.isNull(postorder) || postorder.length < 1) {
            return Boolean.TRUE;
        }
        return recur(postorder, 0, postorder.length - 1);
    }

    /**
     * 思路：递归分治，首先将左右子树区分开，由后序遍历的特性可知，最后一个节点肯定是头节点，
     * 那么小于头节点的是左子树，大于头节点的则是右子树，不断递归直到 left >= right
     * 结束条件：left >= right
     */
    private boolean recur(int[] postorder, int left, int right) {
        // 如果说left > right 则说明没有元素，如果left==right 则说明只有一个元素
        if (left >= right) {
            return Boolean.TRUE;
        }

        int tmpIndex = left;
        while (postorder[tmpIndex] < postorder[right]) {
            tmpIndex++;
        }
        // [,)左闭右开区间，
        int middle = tmpIndex;
        while (postorder[tmpIndex] > postorder[right]) {
            tmpIndex++;
        }
        return tmpIndex == right && (recur(postorder, left, middle - 1))
                && recur(postorder, middle, right - 1);
    }
}
