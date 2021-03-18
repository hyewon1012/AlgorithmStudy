package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * �������� ��������
5 10 
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1
*/
public class KruskalTest {
	
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			//return this.weight - o.weight; // ����ġ�� ���� ������� (�� - �ٸ���) ���� �������� ��뻩��
			return Integer.compare(this.weight, o.weight); //����ġ�� ���,���� ��������� ����÷ο� �����÷ο� ����
		}
		
	}
	
	static int V,E;
	static int parents[];
	static Edge[] edgeList;
	
	static void make() { // ũ�Ⱑ 1�� ���������� �����.
		for (int i = 0; i < V; i++) {
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V];
		edgeList = new Edge[E];

		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		// 1. ��������Ʈ ����ġ ���� �������� ����
		Arrays.sort(edgeList);
		
		make();
		
		int result = 0;
		int count = 0;
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == V-1)break;
			}
		}
		System.out.println(result);
	}

}
