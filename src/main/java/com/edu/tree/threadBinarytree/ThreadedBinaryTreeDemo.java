package com.edu.tree.threadBinarytree;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		//测试一把中序线索二叉树的功能
		Integer[] array = {1,3,4,5,6,7};
		
		//把数组传给ThreadedBinaryTree 创建二叉树
		ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(array);

		threadedBinaryTree.preThreadedNodes();

		System.out.println("使用线索化的方式遍历 线索化二叉树");
		threadedBinaryTree.preThreadedList(); // 8, 3, 10, 1, 14, 6
		
	}

}