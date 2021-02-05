package com.ssafy.permutationAndComb;

import java.util.Arrays;

public class Comb {
	
	static int[] numbers;
	static int N = 4, R = 2;
	
	static void combination(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		else {
			for (int i = start; i <= N; i++) { //i : 시도하는 수
				numbers[cnt] = i;
				combination(cnt+1, i+1);
			}
		}
	}
	
	public static void main(String[] args) {
		numbers = new int[R];
		combination(0, 1);
		

	}

}
