package com.ssafy.permutationAndComb;

import java.util.Scanner;

public class S1_SubSetTest {
	
	static int N, S, totalCnt;
	static int[] input;
	static boolean[] isSelected;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0);
		System.out.println("총 경우의 수 : " +totalCnt);
	}
	
	//현 원소를 부분집합의 구성에 반영
	private static void generateSubset(int cnt) {
		if(cnt == N) {
			int sum=0, selectedCnt=0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sum += input[i];
					selectedCnt++;
				}
			}
			if(sum == S && selectedCnt>0) {
				++totalCnt;
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) System.out.print(input[i] + "\t");
				}
				//여기에 return을 하면 부분집합 구성 못하고 바로 끝난다.
				System.out.println();
			}
			return; // 더 이상 부분집합을 구성하지 못할때 돌아가는 return이다.
		}	
		//선택
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		//비선택
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}
}
