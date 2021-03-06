package com.ssafy.bruteforce;

import java.util.Arrays;
import java.util.Scanner;
//nPn
//원본 배열이 계속 바뀌는 형태
public class NextPermutationTest {

	static int N;
	static int[] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input); // 오름차순 정렬하여 가장 작은 순열의 상태로 만듦.
		do {
			System.out.println(Arrays.toString(input));
		}while(np());
	}
	//true : 다음순열있다
	//flase : 다음순열없다 ( 현 순열이 가장 큰 순열이다)
	public static boolean np() {
		int i = N-1;
		while(i > 0 && input[i-1] >= input[i] ) --i;
		
		//더이상 앞자리가 없는 상황 : 순열의 상태가 가장 큰순열(마지막 순열)
		if(i==0) return false;
		
		//뒤쪽부터 탐색하며 교환위치(i-1)와 교환할 큰 값 위치(j)찾기
		//꼭대기(i)가 존재하므로 항상 i-1보다 큰값(교환할값)이 존재한다.
		int j = N-1;
		while(input[i-1] >= input[j]) --j;
		swap(i-1, j);
		
		int k = N-1;
		//꼭대기 위치부터 맨뒤까지 오름차순 정렬
		while(i < k) {
			swap(i++, k--);
		}
		return true;		
	}
	
	private static void swap(int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	

}
