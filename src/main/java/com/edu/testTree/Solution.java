package com.edu.testTree;



import java.util.HashMap;

class Solution {

    HashMap<Integer,Integer> map=new HashMap<>();
    int [] po;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po=preorder;
        //把
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return recur(0,0,inorder.length-1);
    }

    TreeNode recur(int pre_root,int in_left,int in_right){
        if(in_left>in_right){
            return null;
        }
        TreeNode root=new TreeNode(po[pre_root]);
        int i=map.get(po[pre_root]);
        root.left=recur(pre_root+1,in_left,i-1);
        root.right=recur(pre_root+i-in_left+1,i+1,in_right);
        return root;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        s.buildTree(preorder,inorder);
    }
}