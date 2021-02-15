package com.ssafy.bruteforce;

import java.util.Arrays;
import java.util.Scanner;
//nPn
public class PermutationBitMaskTest {

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
		permutation(0,0);
		

	}
	
	private static void permutation(int cnt, int flag) {
		if (cnt == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		else {
			for (int i = 0; i < N; i++) {
				if((flag & 1<<i) != 0) continue;
				result[cnt] = input[i];
				permutation(cnt+1, flag | 1<<i);
			}
		}
	}

}
