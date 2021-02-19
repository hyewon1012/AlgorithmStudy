package com.ssafy.makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2615 {
	private static int winColor = 0;
	private static int[][] m;
	private static int[] dy = {-1, 0, 1, 1}; //우상, 우, 우하, 하
	private static int[] dx = {1, 1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = new int[19+2][19+2]; // 배열의 경계 테투리를 1줄 사용
		for (int i = 1; i <= 19; i++) { //0번은 안씀, 1~19
			String line = br.readLine();
			for (int j = 1, index=0; j <= 19; j++, index += 2) {
				m[i][j] = line.charAt(index) - '0';
			}
		}
		for (int r = 1; r <= 19; r++) { //행
			for (int c = 1; c <= 19; c++) { // 열
				if(m[r][c] == 0) continue; // 돌이 놓여있지 않으면, 다음칸으로 넘어간다.
				//오목인지 확인
				if(complete(r,c)) {
					System.out.println(winColor);
					System.out.println(r + " " + c);
					return; // 프로그램 종료
				}
				
			}
			
		}
		System.out.println(0); //승리를 결정하지 못하는 경우
		
	} // end of main
	/** r,c 좌표에서 시작하는 오목이 되는지 확인하고, 오목이면 true 아니면 false */
	private static boolean complete(int r, int c) {
		int color = m[r][c];
		dir:for (int k = 0; k < 4; k++) { // 4가지 오목 방향
			
			//이전 칸은 다른 색인지 확인
			if(m[r-dy[k]][c-dx[k]] == color) {
				continue;
			}
			//오목인지 확인
			for (int i = 1; i < 5; i++) {
				if(m[r + dy[k]*i][c + dx[k]*i] != color) { //같은 색이어야함
					continue dir; // 다음 방향으로 넘어가기
				}
			}
			//이후 칸은 다른 색인지 확인
			if(m[r+dy[k]*5][c+dx[k]*5] == color) {
				continue;
			}
			//이때가 오목.
			winColor = color;
			return true;
		}// end of for k
		return false;
	}

} // end of class
