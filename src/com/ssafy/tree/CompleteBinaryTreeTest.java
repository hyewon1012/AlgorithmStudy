package com.ssafy.tree;

public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		int size = 9;
		CompleteBinaryTree tree = new CompleteBinaryTree(size);
		
		for (int i = 0; i < size; i++) {
			tree.add((char)(65+i)); // ���ĺ� �빮��
		}
		
		tree.bfs();

	}

}
