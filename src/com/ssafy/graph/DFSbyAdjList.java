package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class DFSbyAdjList {
	
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
	static Node[] adjList;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		adjList = new Node[N];
		visited = new boolean[N];
		
		StringTokenizer st = null;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			//adjList[from] 배열로 보는게 아님. from의 정점의 헤드를 새로만드는얘로 바꾼다.
			//새로만드는얘가 첫번째가 되기 위해선 기존 헤드에들어있던걸 자신의 next로 오게해서 자기 뒤에 오게만듦.
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[from]);
		}
		
		//bfs();
		
		dfs(0);
	}
	private static void dfs(int current) {
		visited[current] = true;//들어가기전에 방문체크 vs 들어가고 방문체크 차이는 없는데 실수하지마!!
		System.out.println((char)(current+65));
		
		for (Node temp = adjList[current]; temp != null; temp = temp.next) {
			if(!visited[temp.vertext]) {
				dfs(temp.vertext);
			}
		}
		
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
			
			for (Node temp = adjList[current]; temp != null; temp = temp.next) {
				if(!visited[temp.vertext]) {
					visited[temp.vertext] = true;
					queue.offer(temp.vertext);
				}
			}
			
		}
		
	}
}
