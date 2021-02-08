package com.ssafy.permutationAndComb;

import java.util.Arrays;

public class PermutationTest {

	static int[] numbers;
	static int N = 4;
	static boolean[] isSelected;
	
	
	static void permutation(int cnt) { // cnt : 직전까지 뽑은 순열의 개수
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= N; i++) { //1~N 원소 가지고 있음. i:시도하는숫자
			if(isSelected[i]) continue;
			else {
				numbers[cnt] = i;
				isSelected[i] = true;
				permutation(cnt+1); // 다음자리 순열 뽑으라고 보낸다.
				isSelected[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		numbers = new int[N];
		isSelected = new boolean[N+1];		
		permutation(0);
	}

}
