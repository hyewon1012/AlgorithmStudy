package com.ssafy.makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠검증 {

	static int[][] map;
	
	private static boolean solve(int y, int x) {
		int sum=0;
		boolean row=false,col=false,area=false;
		//1. 가로
		for (int i = 0; i < 9; i++) {
			sum += map[y][i];
		}
		if(sum == 45) row = true;
		//2. 세로
		sum=0;
		for (int i = 0; i < 9; i++) {
			sum += map[i][y];
		}
		if(sum == 45) col = true;
		//3. 3*3 영역
		sum = 0;
		for (int i = y; i < y+3; i++) {
			for (int j = x; j < x+3; j++) {
				sum += map[i][j];
			}
		}
		if(sum == 45) area = true;
		
		return (row && col && area);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		map = new int[9][9]; // 한 번 만들어서 재사용
		for (int t = 1; t <= TC; t++) {
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//solve
			int answer = 1;
			for (int i = 0; i < 9; i+=3) {
				for (int j = 0; j < 9; j+=3) {
					if(!solve(i,j)) {
						answer = 0;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

}
