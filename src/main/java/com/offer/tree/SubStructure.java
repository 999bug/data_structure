package com.offer.tree;

import com.offer.base.TreeNode;

import java.util.Objects;

/**
 * @Author: Lisy
 * @Date: 2022/08/12/9:37
 * @Description: 判断树b是否是树a的子结构
 */
public class SubStructure {

    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if(a == null || b == null) {
            return false;
        } else {
            // 遍历 a 中每一个节点，a中任意一个节点包含b都返回true
            return hasSubTree(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b);
        }
    }

    /**
     * 判断树b是否为树a的子结构
     */
    private boolean hasSubTree(TreeNode a, TreeNode b) {
        // 如果b的节点为空，那么b树的节点遍历完毕返回true
        if (Objects.isNull(b)) {
            return true;
        }
        // 如果树 a为空或者 a的节点不等于 b的节点则返回false
        if (Objects.isNull(a) || a.val != b.val) {
            return false;
        }
        // 若a与b的节点值相等，还要判断是否是左节点和左节点 右节点和右节点相等
        return hasSubTree(a.left, b.left) && hasSubTree(a.right, b.right);
    }
}
