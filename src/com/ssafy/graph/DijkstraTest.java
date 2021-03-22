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
		
		int start = 0; // ����� ��ȣ
		int end = V-1; // ������ ��ȣ
		
		int[][] adjMatrix = new int[V][V]; // �������
		
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
			//step1 : ó������ ���� �����߿� ��������� ���� �����(�ּҺ��) ���� ����
			int min = Integer.MAX_VALUE;
			int current = 0; //min �ּҺ�뿡 �ش��ϴ� ���� ��ȣ
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			if(current == end) break;
			//step2 : ���õ� current�� �������� �Ͽ� ���� ó������ ���� �ٸ� ���������� �ּҺ�� ��������.
			for(int j=0; j < V; j++) {
				//adjMatrix[current][j] != 0 : ����Ǿ��ִ°�츸
				if(!visited[j] && adjMatrix[current][j] != 0 && distance[j] > min + adjMatrix[current][j]) {
					distance[j] = min + adjMatrix[current][j]; // �����Ѱ� �����ϸ� ������Ʈ
				}
			}
			
		}
		System.out.println(distance[end]);
		
	}

}
