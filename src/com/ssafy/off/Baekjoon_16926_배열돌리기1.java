package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_16926_�迭������1 {
	static int[][] map;
	static int[] dy = {1,0,-1,0}; // �Ʒ� -> ������ -> �� -> ����
	static int[] dx = {0,1,0,-1}; // �Ʒ� -> ������ -> �� -> ����
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);
		int R = Integer.parseInt(info[2]);
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int group = Math.min(N, M) / 2;
		while(R-- > 0) {
			for (int i = 0; i < group; i++) {
				dfs(i, i, 0, i, map[i][i+1]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}
	/**
	 * �迭 n�� ������.
	 * groupCnt : �ۿ������� ������ �׷� ��ȣ (�������ȣ 0����)
	 * */
	private static void dfs(int y, int x, int dir, int groupCnt, int beforeVal) {
		//base case
		if(dir>=3 && (y == groupCnt && x == groupCnt)) return; // �ѹ��� �� ���� �ٽ� ó����ġ�ο����� ����
		
		int now = map[y][x];
		map[y][x] = beforeVal;
		
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		
		//dir�������� ��� ���������Ҷ�
		//���̰� 5 0 123 4 �������ȣ��ŭ ���� ��������
		if(ny >= groupCnt && ny < map.length-groupCnt && nx >= groupCnt && nx < map[0].length-groupCnt) {
			dfs(ny, nx, dir, groupCnt, now);
		}
		//dir�ٲ�����Ҷ�
		else {
			int nextDir = dir+1;
			ny = y + dy[nextDir];
			nx = x + dx[nextDir];
			dfs(ny, nx, nextDir, groupCnt, now);
		}
		
	}

}
