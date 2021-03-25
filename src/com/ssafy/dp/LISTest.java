package com.ssafy.dp;

import java.util.Scanner;
/*
 * LIS : 원소가 n개인 배열의 일부 원소를 골라내서 부분 수열을 만들었을때,
 * 각 원소는 이전 원소보다 더 크다는 조건을 만족하는 길이가 최대인 부분수열
 * LIS[n] : 전체 수열의 n번째 까지 고려했을때 만들어지는 최장수열의 길이
 * */
public class LISTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr= new int[N]; // 원소들 저장
		int[] LIS = new int[N]; // 각 원소를 마지막에 세웠을때 최장 길이
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			LIS[i] = 1; // 자기혼자 서있을때는 무조건 1
			for (int j = 0; j < i; j++) { // 맨앞부터 자신의 직전 원소들과 비교
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
