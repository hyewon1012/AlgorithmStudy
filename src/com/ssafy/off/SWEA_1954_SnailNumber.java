package com.ssafy.off;

import java.util.Scanner;

public class SWEA_1954_SnailNumber {
	
	public static void solve(int N, int[][] map) {
		int cnt = 1; //�迭 �� ĭ�� ���� ����
		int dir = 1; //������Ⱚ 1 or -1
		int y = 0, x = -1; //������
		int size = N*N;
		while(cnt <= size) {
			//��->��->��->��
			
			//�� : x�� ����, �� : x�� ���� 
			for (int k = 0; k < N; k++) {
				x += dir;
				map[y][x] = cnt;
				cnt++;
			}
			
			N--; // ��->��, ��->��
			
			//�� : y�� ����, �� : y�� ����
			for (int k = 0; k < N; k++) {
				y += dir;
				map[y][x] = cnt;
				cnt++;
			}
			dir*=(-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[][] map;
		for (int t = 1; t <=tc; t++) {
			int N = sc.nextInt();
			//solve
			map = new int[N][N];
			int y = 0;
			int x = 0;
			int ele = 1;
			int rowSize = N;
			int colSize = N-1;
			/*
			while(ele <= N*N) {
				//�����ʹ���
				for (int i = 0; i < rowSize; i++) {
					map[y][x++] = ele++;
				}
				--rowSize;
				++y;
				--x;
				//��->�Ʒ�
				for (int i = 0; i < colSize; i++) {
					map[y++][x] = ele++; 
				}
				--colSize;
				--y;
				--x;
				//���ʹ���
				for (int i = 0; i < rowSize; i++) {
					map[y][x--] = ele++;
				}
				--rowSize;
				--y;
				++x;
				//�Ʒ� -> ��
				for (int i = 0; i < colSize; i++) {
					map[y--][x] = ele++;
				}
				--colSize;
				++y;
				++x;
			}
			*/
			solve(N,map);
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
				
			}

		}
		
		

	}

}
