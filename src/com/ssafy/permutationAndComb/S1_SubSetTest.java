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
		System.out.println("�� ����� �� : " +totalCnt);
	}
	
	//�� ���Ҹ� �κ������� ������ �ݿ�
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
				//���⿡ return�� �ϸ� �κ����� ���� ���ϰ� �ٷ� ������.
				System.out.println();
			}
			return; // �� �̻� �κ������� �������� ���Ҷ� ���ư��� return�̴�.
		}	
		//����
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		//����
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}
}
