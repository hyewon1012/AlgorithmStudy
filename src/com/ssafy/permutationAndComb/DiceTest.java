package com.ssafy.permutationAndComb;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
	static int[] numbers;
	static int N,totalCnt;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		isSelected = new boolean[7]; //1-6���� �ֻ��� �� ��뿩��
		
		int M = sc.nextInt(); // ������ ���
		totalCnt = 0;
		
		switch(M) {
		case 1:
			dice1(0);
			break;
		case 2:
			dice2(0);
			break;
		case 3:
			dice3(0,1);
			break;
		case 4:
			dice4(0,1);
			break;
		default:
			break;
		}
		System.out.println("�� ����� �� : " + totalCnt);
		
	}
	// �ߺ����� : n��r ==> n^r 
	private static void dice1(int cnt) {
		if(cnt == N){
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
	}
	//���� : nPr
	private static void dice2(int cnt) {
		if(cnt == N){
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			
			isSelected[i] = true;
			
			dice2(cnt+1);
			
			isSelected[i] = false;
		}
	}
	//�ߺ����� : nHr : n+r-1Cr : 8C3 = 53
	private static void dice3(int cnt, int start) {
		if(cnt == N){
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i);
		}
	}
	//���� : nCr 6C3 : 56
	private static void dice4(int cnt, int start) {
		if(cnt == N){
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i+1);
		}
	}
}
