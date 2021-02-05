package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861_���簢���� {
/**
 * ���̿켱Ž��
 * �̵��Ҽ��ִ� ���� ������ �����Ѱ��� �������� ���� ���� �� ��ȣ ���
*/
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static int[][] map;
	static int ans;
	static int startRoom;
	//���������� �ִ��� ���� �Ÿ��� ���������� ���� �̵��� �Ÿ��� ���� 
	public static void dfs(int y, int x, int startVal, int[][] map, int cnt) {
		
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			
			if(ny >= 0 && ny < map.length && nx >= 0 && nx < map.length) {
				if(map[ny][nx] == map[y][x]+1) {
					dfs(ny,nx, startVal, map, ++cnt);
				}	
			}
		}
		
		if(ans < cnt) {
			ans = cnt;
			startRoom = startVal;
		}
		//������ �������϶�
		if(ans == cnt) {
			if(startRoom > startVal) startRoom = startVal;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			//�Է�
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//solve
			startRoom = map[0][0];
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i,j,map[i][j],map,1);
				}
			}
			System.out.println("#"+t+" " +startRoom + " " +ans);
			
			
		}

	}

}
