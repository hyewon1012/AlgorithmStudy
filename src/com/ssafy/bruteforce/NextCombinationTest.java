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
		P = new int[N]; // N ũ���� flag �迭
		
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
	
	//true : ���������ִ�
	//flase : ������������ ( �� ������ ���� ū �����̴�)
	public static boolean np() {
		int i = N-1;
		while(i > 0 && P[i-1] >= P[i] ) --i;
		
		//���̻� ���ڸ��� ���� ��Ȳ : ������ ���°� ���� ū����(������ ����)
		if(i==0) return false;
		
		//���ʺ��� Ž���ϸ� ��ȯ��ġ(i-1)�� ��ȯ�� ū �� ��ġ(j)ã��
		//�����(i)�� �����ϹǷ� �׻� i-1���� ū��(��ȯ�Ұ�)�� �����Ѵ�.
		int j = N-1;
		while(P[i-1] >= P[j]) --j;
		swap(i-1, j);
		
		int k = N-1;
		//����� ��ġ���� �ǵڱ��� �������� ����
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
