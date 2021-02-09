package com.ssafy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

	private char[] nodes;
	private int lastIndex;
	private final int SIZE;
	
	public CompleteBinaryTree(int size) {
		super();
		SIZE = size;
		nodes = new char[size+1];
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(char e) {
		if(isFull()) {
			System.out.println("포화상태입니다.");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		
		if(isEmpty()) return;
		
		//탐색 순서 번호를 큐로 관리
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		int current;
		while(!q.isEmpty()) {
			current = q.poll();
			System.out.println(nodes[current]);
			if(current*2 <= lastIndex) q.offer(current*2); // 왼쪽 자식
			if(current*2+1 <= lastIndex) q.offer(current*2+1); // 오른쪽 자식
		}
		
	}
	
	public void bfs2() {
		
		if(isEmpty()) return;
		
		//탐색 순서 번호를 큐로 관리
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		int current, size, level = 0;
		while(!q.isEmpty()) {
			
			size = q.size();// 각 level별 노드의 개수
			System.out.print("level"+level+":");
			while(--size >= 0) {
				current = q.poll();
				System.out.print(nodes[current]);
				if(current*2 <= lastIndex) q.offer(current*2); // 왼쪽 자식
				if(current*2+1 <= lastIndex) q.offer(current*2+1); // 오른쪽 자식
			}
			System.out.println();
			++level;
		}
		
	}
	
	//전위 순회
	public void dfs(int current) {
		if(current > lastIndex) {
			return;
		}
		//VLR
		System.out.println(nodes[current]); // 방문 관련 처리 -> 전위순회
		dfs(current*2);
		//System.out.println(nodes[current]); // 방문 관련 처리 -> 중위순회
		dfs(current*2+1);
		//System.out.println(nodes[current]); // 방문 관련 처리 -> 후위순회
		
	}

	//중위 순회
	public void inorder(int current) {
		if(current > lastIndex) {
			return;
		}
		//VLR
		inorder(current*2);
		System.out.println(nodes[current]); // 방문 관련 처리 -> 중위순회
		inorder(current*2+1);
	}
	
	//후위 순회
	public void postorder(int current) {
		if(current > lastIndex) {
			return;
		}
		//VLR
		postorder(current*2);
		postorder(current*2+1);
		System.out.println(nodes[current]); // 방문 관련 처리 -> 후위순회
	}
}
