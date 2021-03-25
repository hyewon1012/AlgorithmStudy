package com.ssafy.dp;

import java.util.Scanner;
/*
 * LIS : ���Ұ� n���� �迭�� �Ϻ� ���Ҹ� ��󳻼� �κ� ������ ���������,
 * �� ���Ҵ� ���� ���Һ��� �� ũ�ٴ� ������ �����ϴ� ���̰� �ִ��� �κм���
 * LIS[n] : ��ü ������ n��° ���� ��������� ��������� ��������� ����
 * */
public class LISTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr= new int[N]; // ���ҵ� ����
		int[] LIS = new int[N]; // �� ���Ҹ� �������� �������� ���� ����
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			LIS[i] = 1; // �ڱ�ȥ�� ���������� ������ 1
			for (int j = 0; j < i; j++) { // �Ǿպ��� �ڽ��� ���� ���ҵ�� ��
				if(arr[j] < arr[i] && LIS[j] < LIS[j]+1) {
					LIS[i] = LIS[j] + 1;
					
				}
			}
			if(max < LIS[i]) {
				max = LIS[i];
			}
		}
		System.out.println(max);
		
	}
	
	private static void LIS(int N, int[] arr, int[] LIS) {
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] < arr[j]) {
					LIS[i] = Math.max(LIS[j], LIS[i]+1);
				}
			}
			if(max < LIS[i]) {
				max = LIS[i];
			}
		}
		System.out.println(max);
	}

}
