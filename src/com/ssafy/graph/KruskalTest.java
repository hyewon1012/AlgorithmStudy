package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 정점개수 간선개수
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
			//return this.weight - o.weight; // 가중치가 작은 순서대로 (나 - 다른거) 나를 기준으로 상대빼기
			return Integer.compare(this.weight, o.weight); //가중치가 양수,음수 모두있을때 언더플로우 오버플로우 방지
		}
		
	}
	
	static int V,E;
	static int parents[];
	static Edge[] edgeList;
	
	static void make() { // 크기가 1인 단위집합을 만든다.
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		//return findSet(parents[a]); // path compression 전
		return parents[a] = findSet(parents[a]); // path compression 후 : 나의 대표자를 최고 부모로 바꾸자!!
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot; // 합쳐야함. a집합에 b를 흡수
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
		
		// 1. 간선리스트 가중치 기준 오름차순 정렬
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
