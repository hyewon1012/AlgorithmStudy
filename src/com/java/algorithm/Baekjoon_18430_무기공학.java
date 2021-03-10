package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_18430_무기공학 {
	static int[][][] dir = {
			{{0,-1},{0,0},{1,0}}, // ㄱ
			{{-1,0},{0,0},{0,-1}}, // ㄴ뒤집은모양
			{{-1,0},{0,0},{0,1}}, // ㄴ
			{{1,0},{0,0},{0,1}}, // ㄱ 뒤집은모양
	};
	
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
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				solve(i,j);
			}
		}

	}
	private static void solve(int y, int x) {
		int sum = Integer.MIN_VALUE;
//		for (int k = 0; k < 4; k++) {
//			if(k==0) {
//				for (int i = 0; i < 3; i++) {
//					int ny = y + dir[k][i][0];
//					int nx = x + dir[k][i][1];
//					if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;
//					System.out.println("k "+k+" : "+ny+","+nx);
//				}
//			}
//
//			
//		}
		
		int ny=0,nx=0;
		for (int i = 0; i < 3; i++) {
			ny = y + dir[0][i][0];
			nx = x + dir[0][i][1];
			if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;

		}

		
		
	}

}
