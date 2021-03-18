package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] minEdge = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken()); 
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result = 0;
		minEdge[0]=0;
		
		for (int c = 0; c < N; c++) {
			// 신장트리에 연결되지 않은 정점중 minEdge 비용이 최소인 정점
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for (int i = 0; i < N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			result += min;
			visited[minVertex] = true;
			
			//지금선택된 정점 기준 선택할수있는 정점 -> 기존에 연결되있는것보다 나한테서 오는게 더 유리하면 업데이트
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.println(result);
	}

}
