package com.ssafy.divideAndconquer;

import java.util.Scanner;

public class NQueenTest_BackTracking {
	static int ans,N;
	static int[] col;
	
	//같은 행에는 놓지않는 방식이기때문에 열만 기억하는 방법 <- 1차원배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		setQueen(0);
		System.out.println(ans);
		
	}
	//유망하지않으면 아예 가지마 방법도 있지만
	//백트래킹에서는 갔다가 아니면 돌아오는 방식 느낌을 주기위해 갔다가 돌아오자.
	private static void setQueen(int rowNo) {
		// 현재 노드가 유망하지 않다면 돌아가기
		if(!isAvailable(rowNo)) {
			return;
		}
		if(rowNo == N) {
			ans++;
			return;
		}
		
		//자식노드의 가지를 파생
		for (int i = 1; i <= N; i++) {
			col[rowNo+1] = i;
			setQueen(rowNo+1);
		}
	}
	//가로 세로 대각선 검사
	private static boolean isAvailable(int rowNo) {
		for (int i = 1; i < rowNo; i++) {
			//퀸이 서로 위협적인 위치면 false
			//모든 퀸이랑 같은 열이거나 대각선 위치에 놓여져있다면 false
			if(col[rowNo] == col[i] || Math.abs(col[rowNo]-col[i]) == rowNo-i) return false;
		}
		return true;
	}
}
