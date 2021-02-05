package com.ssafy.off;

import java.util.Scanner;

public class SWEA_2805_Crops {
	
	static int[][] map;
	static int N;
	static int center;
	
	private static int getHarvest() {
		//harvest:����, begin : ���࿡�� ��Ȯ�� ĭ�� ���� �ε���
		//end : ���࿡�� ��Ȯ�� ĭ�� ������ �ε���
		//gap : ���ึ�� begin, end���� ������ ����
		int harvest = 0, begin=0, end = 0, gap=0;
		
		for (int i = 0; i < N; i++) {
			begin = center - gap; // �߾ӿ��� �������� �̵�
			end = center + gap; // �߾ӿ��� �������� �̵�
			
			for (int j = begin; j <= end; j++) {
				harvest += map[i][j];
			}//�־���������Ȯ
			
			if(i < center) {//�߾Ӻ��� ���� ��
				gap++;
			}else { //center ���� �Ʒ��� �� 
				gap--;
			}
		}
		return harvest;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			center = N/2;
			for (int i = 0; i < N; i++) {
				String temp = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp.charAt(j) - '0';
				}
			}

			int i=N/2, j=N/2;
			int answer = 0;
			int y=0;
			
			answer += map[y++][i];
			i--; j++;
			while(y <= N/2) {
				for (int k = i; k <= j; k++) {
					answer += map[y][k];
				}
				i--; j++; y++;
			}
			i+=2; j-=2;
			while(N/2 < y && y <= N-1) {
				for (int k = i; k <= j; k++) {
					answer += map[y][k];
				}
				i++; j--; y++;
			}
				
				
			
			System.out.println("#"+t+" "+answer);
		}
		

	}

}
