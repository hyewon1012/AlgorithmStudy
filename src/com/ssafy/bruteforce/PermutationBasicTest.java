package com.ssafy.bruteforce;

import java.util.Arrays;
import java.util.Scanner;
//nPn
public class PermutationBasicTest {

	static int N;
	static int[] input, result;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		result = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0);
		

	}
	
	private static void permutation(int cnt) {
		if (cnt == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		else {
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) continue;
				result[cnt] = input[i];
				
				isSelected[i] = true;
				
				permutation(cnt+1);
				
				isSelected[i] = false; //i번째 숫자가 순서를 바꿔서 다시 뽑힐수 있도록 해준다.
			}
		}
	}

}
