package com.ssafy.bruteforce;

import java.util.Scanner;

public class NextCombinationTest {
	static int N,R;
	static int[] input;
	static int[] P;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		P = new int[N]; // N 크기의 flag 배열
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		int cnt = 0;
		while(++cnt<=R) P[N-cnt]=1;
		
		do {
			for (int i = 0; i < N; i++) {
				if(P[i]==1) System.out.print(input[i]+" ");
			}
			System.out.println();
		}while(np());
		

	}
	
	//true : 다음순열있다
	//flase : 다음순열없다 ( 현 순열이 가장 큰 순열이다)
	public static boolean np() {
		int i = N-1;
		while(i > 0 && P[i-1] >= P[i] ) --i;
		
		//더이상 앞자리가 없는 상황 : 순열의 상태가 가장 큰순열(마지막 순열)
		if(i==0) return false;
		
		//뒤쪽부터 탐색하며 교환위치(i-1)와 교환할 큰 값 위치(j)찾기
		//꼭대기(i)가 존재하므로 항상 i-1보다 큰값(교환할값)이 존재한다.
		int j = N-1;
		while(P[i-1] >= P[j]) --j;
		swap(i-1, j);
		
		int k = N-1;
		//꼭대기 위치부터 맨뒤까지 오름차순 정렬
		while(i < k) {
			swap(i++, k--);
		}
		return true;		
	}
	
	private static void swap(int i, int j) {
		int temp = P[i];
		P[i] = P[j];
		P[j] = temp;
	}

}
