package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1227_미로2 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = 10;
		
		for (int i = 1; i <= TC; i++) {
			int t = Integer.parseInt(br.readLine());
			map = new int[100][100];
			visited = new boolean[100][100];
			//입력
			for (int y = 0; y < 100; y++) {
				String s = br.readLine();
				for (int x = 0; x < 100; x++) {
					int val = s.charAt(x)-'0';
					map[y][x] = val;
				}
			}
			ans = 0;
			//solve
			solve(1,1);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
			
		}// end of test case
		System.out.print(sb);
		
	}// end of main
	
	private static void solve(int i, int j) {
		if(map[i][j] == 3) {
			ans = 1;
			return;
		}
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int ny = i + dy[k];
			int nx = j + dx[k];
			if(ny >= 100 || ny < 0 || nx >= 100 || nx < 0) continue;
			if(map[ny][nx] != 1 && !visited[ny][nx]) {
				visited[ny][nx] = true;
				solve(ny,nx);
				visited[ny][nx] = false;
			}
		}

	}

}
