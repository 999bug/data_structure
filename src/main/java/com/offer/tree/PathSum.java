package com.offer.tree;

import com.ncst2.dynamic.Lis;
import com.offer.base.BaseTreeUtils;
import com.offer.base.TreeNode;

import java.util.*;

/**
 * @Author: Lisy
 * @Date: 2022/08/16/15:51
 * @Description: 二叉树中某一路径的和与目标值相同
 */
public class PathSum extends BaseTreeUtils {

    public static void main(String[] args) {
        String[] strings = new String[]{"5", "4", "8", "11", "null", "13", "4", "7", "2", "null", "null", "5", "1"};
        TreeNode treeNode = stringToTreeNode(strings);
        List<List<Integer>> lists = new PathSum().pathSum(treeNode, 22);
        lists.forEach(System.out::println);
    }

    /**
     * 返回集合
     */
    private final List<List<Integer>> results = new LinkedList<>();
    /**
     * 每一条成功的路径
     */
    private final LinkedList<Integer> paths = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        recur(root, target);
        return results;
    }

    /**
     * 思路：利用前序遍历(递归)和回溯的特点，逐一遍历节点计算差值,当差值等于 0 且为子节点将这条线路添加到集合中
     * 递归终止条件：该节点无左右子节点时返回
     */
    private void recur(TreeNode node, int target) {
        if (Objects.isNull(node)) {
            return;
        }
        paths.add(node.val);
        target -= node.val;
        if (target == 0 && Objects.isNull(node.left) && Objects.isNull(node.right)) {
            results.add(new LinkedList<>(paths));
        }
        recur(node.left, target);
        recur(node.right, target);
        paths.removeLast();
    }
}
