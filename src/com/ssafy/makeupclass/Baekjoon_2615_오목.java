package com.ssafy.makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 완전탐색 가능함 : 19*19*4*7
 * */
public class Baekjoon_2615_오목 {
/**
 * 19*19 바둑판 5개 연속적이면 승리
 * 승리 -> 가장 왼쪽에있는 바둑할 row,col 출력
 * 가로방향 세로방향 대각선방향 dfs.
 * basis case
 * 1. 연속적으로 동일한 색깔 5개일때 return 1 or 2(바둑색깔)
 * 2. ny, nx 범위 밖
 * 3. cnt < 5 and 끊겼을때 return 0 
 * */
	final static int N = 19;
	static int[][] map;
	//오른쪽, 아래, 오른쪽 아래 대각선, 오른쪽 위 대각선
	static int[] dy = {0,1,1,-1};
	static int[] dx = {1,0,1,1};
	
	static int ans;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		
		ans = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//solve
		
		int ansY = 0, ansX = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						solve(i,j,k,0);
						if(ans != -1) {
							ansY = i;
							ansX = j;
							System.out.println(ansY+1+" " + ansX+1);
							
						}
						
					}
					
				}
			}
		}
		
	}// end of main
	
	private static int solve(int y, int x, int dir, int cnt) {
//		if(cnt > 5) {
//			ans = 0;
//			return;
//		}
//		
		if(cnt >= 5) {
			//바둑알색깔
			System.out.println(map[y][x]);
			ans = map[y][x];
			//오목인지 육목인지..
			//색깔판단 오목인지 육목인지 판단
			
			return cnt;
		}
		
		//dir방향으로 계속 이동
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if(ny < 0 || ny >= N || nx < 0 || nx >= N) return 0;
		
		//오목 만들기전에 색깔이 다르면 탈락
		if(map[y][x] != map[ny][nx]) return 0;
		
		if(solve(ny,nx,dir,cnt++) == 5) {
			return cnt;
		}
		return 0;

	}

}
