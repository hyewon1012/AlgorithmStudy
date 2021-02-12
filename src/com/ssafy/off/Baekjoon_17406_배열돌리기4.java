package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_17406_�迭������4 {
	static int[][] map;
	static int[] dy = {0,1,0,-1}; // ������ -> �Ʒ� -> ���� -> ����
	static int[] dx = {1,0,-1,0}; // ������ -> �Ʒ� -> ���� -> ����
	static int r,c,s;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]); // row
		int M = Integer.parseInt(info[1]); // col
		int K = Integer.parseInt(info[2]); // ȸ�� ������ ����
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//ȸ�� ���� ����
		
		for (int i = 0; i < K; i++) {
			String[] rotateInfo = br.readLine().split(" ");
			r = Integer.parseInt(rotateInfo[0]);
			c = Integer.parseInt(rotateInfo[1]);
			s = Integer.parseInt(rotateInfo[2]);
			int groupCnt = Math.min((r+s)-(r-s)+1, (c+s)-(c-s)+1) /2;
			for (int k = 0; k < groupCnt; k++) {
				solve(r-s+k-1, c-s+k-1, k, 0 , map[r-s-1][c-s]);
			}
			
		}
		System.out.println(answer);
	}

	private static void solve(int y, int x, int s, int dir, int beforeVal) {
		if(dir == 4) {
			return;
		}
		int rowMin = y-s;
		int rowMax = y+s;
		int colMin = x-s;
		int colMax = x+s;
		
		int now = map[y][x];
		map[y][x] = beforeVal;
		
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		
		//dir���� ���� �����Ҷ�
		if(ny >= rowMin && ny < rowMax && nx >= colMin && nx < colMax) {
			solve(ny, nx, dir, s, now);
		}else {//dir���� ���� �Ұ��� -> ���� �ٲ�� �� ��
			ny = y + dy[dir+1];
			nx = x + dx[dir+1];
			solve(ny, nx, s, dir+1, now);
		}
		
		
	}
}
