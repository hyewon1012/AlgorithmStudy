package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_18430_무기공학 {
	static int[][][] dir = {
			{{0,0},{0,1},{1,1}}, // ㄱ
			{{0,1},{1,0},{1,1}}, // ㄴ뒤집은모양
			{{0,0},{1,0},{1,1}}, // ㄴ
			{{0,0},{0,1},{1,0}}, // ㄱ 뒤집은모양
	};
	static int[] weight = {1,2,1,0}; // dir에 따른 가중치 인덱스값
	
	static int[][] map;
	static boolean[][] visited;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		N = Integer.parseInt(init[0]);
		M = Integer.parseInt(init[1]);
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

	}
	private static void solve(int y, int x) {
		int sum = Integer.MIN_VALUE;
		
		for (int k = 0; k < 4; k++) {
			visited = new boolean[N][M];
			int[][] shape = dir[k];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
				}
			}
		}
		
	}

}
