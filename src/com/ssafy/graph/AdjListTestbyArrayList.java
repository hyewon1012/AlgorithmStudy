package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
노드 :7 개, 간선 : 8개
간선정보리스트
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
*/
public class AdjListTestbyArrayList {
	
	static class Node{
		int vertext;
		Node next;
		
		public Node(int vertext, Node next) {
			super();
			this.vertext = vertext;
			this.next = next;
		}

		public Node(int vertext) {
			super();
			this.vertext = vertext;
		}

		@Override
		public String toString() {
			return "Node [vertext=" + vertext + ", next=" + next + "]";
		}

	}
	
	static int N;
	static ArrayList<Integer>[] adjList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N]; //배열객체생성
		
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = null;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		bfs();
	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		//탐색시작정점 : 0으로 출발
		int start = 0;
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			//현재 정점에 관련된 처리
			System.out.println((char)(current+65));
			
			for (int temp : adjList[current]) { // temp : current와 인접정점인 해당 정점의 번호
				if(!visited[temp]) {
					visited[temp] = true;
					queue.offer(temp);
				}
			}
			
		}
		
	}
}
