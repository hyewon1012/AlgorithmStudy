package com.ssafy.permutationAndComb;

import java.util.Arrays;

public class PermutationTest {

	static int[] numbers;
	static int N = 4;
	static boolean[] isSelected;
	
	
	static void permutation(int cnt) { // cnt : �������� ���� ������ ����
		if (cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= N; i++) { //1~N ���� ������ ����. i:�õ��ϴ¼���
			if(isSelected[i]) continue;
			else {
				numbers[cnt] = i;
				isSelected[i] = true;
				permutation(cnt+1); // �����ڸ� ���� ������� ������.
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
