package com.ssafy.makeupclass;

import java.util.Scanner;

public class Intermediate {

	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			
			//집 : H, 기지국 :A(1칸),B(2칸),C(3칸) 
			char[][] map = new char[n][n];
			boolean[][] visited = new boolean[n][n]; //방문 여부 체크
			
			int home = 0; //집 갯수
			//지도 정보 입력
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					map[y][x] = sc.next().charAt(0);
					if(map[y][x] == 'H')
						home++;
				}
			}
			//더 빠른 입력
//			for (int i = 0; i < n; i++) {
//				map[i] = sc.next().toCharArray();
//			}
			
			
			int[][] jump = {{1},{1,2},{1,2,3}}; //A,B,C 각각의 범위값
			
			int dy[] = {-1,1,0,0}; //상하좌우
			int dx[] = {0,0,-1,1}; //상하좌우
			
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					//범위값만큼 사방탐색
					if(map[y][x] == 'A') {
						//사방탐색
						
					}
					if(map[y][x] == 'B') {
						for (int r = 0; r < jump[1].length; r++) {
							for (int k = 0; k < 4; k++) {
								int ny = y + (dy[k]*jump[1][r]);
								int nx = x + (dx[k]*jump[1][r]);
								//범위체크 -> 방문안했다면 초기 집 갯수에서 빼준다. -> visited[ny][nx] = true
								if(ny < n && ny >=0 && nx < n && nx >= 0) {
									
								}
							}
						}
					}
					if(map[y][x] == 'C') {
						
					}
					
					
				}
			}
		}

		
		

	}

}
