package com.ssafy.makeupclass;

import java.util.Scanner;

public class Intermediate {

	public static void main(String[] args) {
		//�Է�
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			
			//�� : H, ������ :A(1ĭ),B(2ĭ),C(3ĭ) 
			char[][] map = new char[n][n];
			boolean[][] visited = new boolean[n][n]; //�湮 ���� üũ
			
			int home = 0; //�� ����
			//���� ���� �Է�
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					map[y][x] = sc.next().charAt(0);
					if(map[y][x] == 'H')
						home++;
				}
			}
			//�� ���� �Է�
//			for (int i = 0; i < n; i++) {
//				map[i] = sc.next().toCharArray();
//			}
			
			
			int[][] jump = {{1},{1,2},{1,2,3}}; //A,B,C ������ ������
			
			int dy[] = {-1,1,0,0}; //�����¿�
			int dx[] = {0,0,-1,1}; //�����¿�
			
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					//��������ŭ ���Ž��
					if(map[y][x] == 'A') {
						//���Ž��
						
					}
					if(map[y][x] == 'B') {
						for (int r = 0; r < jump[1].length; r++) {
							for (int k = 0; k < 4; k++) {
								int ny = y + (dy[k]*jump[1][r]);
								int nx = x + (dx[k]*jump[1][r]);
								//����üũ -> �湮���ߴٸ� �ʱ� �� �������� ���ش�. -> visited[ny][nx] = true
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
