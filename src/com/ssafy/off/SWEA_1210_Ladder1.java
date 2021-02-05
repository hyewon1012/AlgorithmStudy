package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {
	final static int N = 100;
	static int answer;
	static int[][] map;
	static boolean [][] visited;
	
	private static int solve(int end, int[][] map) {
		int y = 99, x = end; // ��������ǥ
		while(y > 0) {
			//1. ���������� �̵� �������� -> ��� ���������� �̵�
			if((x+1 < 100) && map[y][x+1] == 1) {
				do {
					x++;
				}while((x+1 < 100) && map[y][x+1] == 1);
			}
			//2. �������� �̵� �������� -> ��� �������� �̵�
			else if((x-1 >= 0) && map[y][x-1] == 1) {
				do {
					x--;
				}while((x-1 >= 0) && map[y][x-1] == 1);
			}
			//3. ���� �̵�
			y--;
		}
		return x;
	}
	
	private static void go(int nowY, int nowX) {
		visited[nowY][nowX] = true;
		if(nowY == 0) {
			answer = nowX;
			return;
		}
		else {
			
			if(nowX-1 < N && nowX-1 >= 0 && visited[nowY][nowX-1] == false && map[nowY][nowX-1] == 1) {//���� �����Ҷ�
				go(nowY, nowX-1);
			}
			else if(nowX+1 < N && nowX+1>=0 && visited[nowY][nowX+1] == false && map[nowY][nowX+1] == 1) {//������ �����Ҷ�
				go(nowY, nowX+1);
			}
			else if(nowY-1 < N && nowY-1 >=0 && visited[nowY-1][nowX] == false && map[nowY-1][nowX] == 1) {//���� �����Ҷ�
				go(nowY-1, nowX);
			}

		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//100x100 ũ�� ��ٸ����� ��������(2)�� �����ִ� ����� x�� ��ȯ (x�� 0����)
		//�Ʒ� ���� ������ Ž��
		//recursion
		//go()
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			map = new int[N][N];
			visited = new boolean[N][N];
			answer = 0;
			int startY = 0, startX = 0;
			//�Է�
			int tc = Integer.parseInt(in.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						startY = i;
						startX = j;
					}
				}
			}//�Է� ��
			
			//solve
			//go(startY, startX);
			answer = solve(startX, map);
			System.out.println("#" + t + " " + answer);
		}

	}

}
