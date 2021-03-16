package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
��� :7 ��, ���� : 8��
������������Ʈ
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
public class AdjMatrixTest {
	
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
	static boolean[][] adjMatrix;
	static Node[] adjList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		adjMatrix = new boolean[N][N];
		
		StringTokenizer st = null;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = adjMatrix[from][to] = true;
		}
		
		bfs();
	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		//Ž���������� : 0���� ���
		int start = 0;
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			//���� ������ ���õ� ó��
			System.out.println((char)(current+65));
			//�������� Ž��
			for (int i = 0; i < N; i++) {
				if(adjMatrix[current][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}
}
