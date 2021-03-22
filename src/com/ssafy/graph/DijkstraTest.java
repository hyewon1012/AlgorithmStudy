package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());
		
		int start = 0; // 출발점 번호
		int end = V-1; // 도착점 번호
		
		int[][] adjMatrix = new int[V][V]; // 인접행렬
		
		StringTokenizer st = null;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		for (int i = 0; i < V; i++) {
			//step1 : 처리하지 않은 정점중에 출발지에서 가장 가까운(최소비용) 정점 선택
			int min = Integer.MAX_VALUE;
			int current = 0; //min 최소비용에 해당하는 정점 번호
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			if(current == end) break;
			//step2 : 선택된 current를 경유지로 하여 아직 처리하지 않은 다른 정점으로의 최소비용 따져본다.
			for(int j=0; j < V; j++) {
				//adjMatrix[current][j] != 0 : 연결되어있는경우만
				if(!visited[j] && adjMatrix[current][j] != 0 && distance[j] > min + adjMatrix[current][j]) {
					distance[j] = min + adjMatrix[current][j]; // 인접한게 유리하면 업데이트
				}
			}
			
		}
		System.out.println(distance[end]);
		
	}

}
