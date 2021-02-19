package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Baekjoon_1987_알파벳 {
/**
 * next[key]의 value가 1일때 이미 지나간것.
 * 갈수있는게 여러개면 다시 돌아와서 탐색
 * 
 * */
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int R,C;
	static HashMap<Character, Integer> alphabet;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		
		R = Integer.parseInt(init[0]);
		C = Integer.parseInt(init[1]);
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = c[j];
			}
		}
		
		alphabet = new HashMap<Character, Integer>();
		ans = Integer.MIN_VALUE;
		dfs(0,0,1);
		System.out.println(ans);
		
	}

	public static void dfs(int y, int x, int cnt) {
		if(alphabet.get(map[y][x]) != null) {
			ans = Math.max(ans, cnt);
			return;
		}else {
			alphabet.put(map[y][x], 1);
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
			if(!visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(ny,nx,cnt++);
				visited[ny][nx] = false;
			}
			
		}
		
		
		
	}

}
