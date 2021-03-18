package com.ssafy.graph;

import java.util.Arrays;

public class DisjointSetTest {
	static int N;
	static int parents[];
	
	static void make() { // ũ�Ⱑ 1�� ���������� �����.
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		//return findSet(parents[a]); // path compression ��
		return parents[a] = findSet(parents[a]); // path compression �� : ���� ��ǥ�ڸ� �ְ� �θ�� �ٲ���!!
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot; // ���ľ���. a���տ� b�� ���
		return true; 
	}
	
	public static void main(String[] args) {
		N = 5;
		parents = new int[N];
		
		make();
		
		System.out.println("=================union======================");
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(1,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3,4));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,4));
		System.out.println(Arrays.toString(parents));
		
		System.out.println("=================find======================");
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents));
	}

}
