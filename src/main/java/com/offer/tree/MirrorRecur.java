package com.offer.tree;

import com.offer.base.BaseTreeUtils;
import com.offer.base.TreeNode;

import java.io.IOException;
import java.util.Objects;

/**
 * @Author: Lisy
 * @Date: 2022/08/12/10:40
 * @Description: 二叉树的镜像
 */
public class MirrorRecur extends BaseTreeUtils {

    public static void main(String[] args) throws IOException {
        int[] line = new int[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode root = intArrayToTreeNode(line);
//        System.out.println(root);
//        TreeNode ret = new MirrorRecur().mirrorTree(root);
//        System.out.println(ret);
//        System.out.println("=========== ");
        levelPrint(root);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

}
