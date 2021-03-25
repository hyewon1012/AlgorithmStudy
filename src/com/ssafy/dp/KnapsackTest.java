package com.ssafy.dp;

import java.util.Scanner;

public class KnapsackTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ���� ����
		int W = sc.nextInt(); // ���� ����
		
		int[] weights = new int[N+1]; // ������ ��������
		int[] profits = new int[N+1]; // ������ ��ġ����
		int[][] D = new int[N+1][W+1]; // �ش繰�Ǳ��� ����Ͽ� �ش繫�Ը� ���鋚�� �ִ� ��ġ
		
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) { // ù ���Ǻ��� ��� 
			for (int w = 1; w <= W; w++) { // ����1���� ���
				if(weights[i] <= w) { // ���濡 ���� �� ������ -> ������ ���� �߿� ū��
					D[i][w] = Math.max(D[i-1][w-weights[i]] + profits[i], D[i-1][w]);
				}else { // ���濡 ���� ���Ҷ�
					D[i][w] = D[i-1][w];
				}
			}
		}
		System.out.println(D[N][W]);
	}

}
