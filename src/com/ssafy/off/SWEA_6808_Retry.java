package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808_Retry {
/**
 * �Կ��� ī�� �Է¹���.(18�忡�� �Կ��� ī�� ���� �ο���ī��) 
 * �̶� �ο��̰� ī���� ������ ��� �ϴ��Ŀ� ���� �Կ��̰� �̱�� ���, ���� ��� ���?
 * @throws IOException 
 * @throws NumberFormatException 
 * */
	static int[] A; //�Կ�
	static int[] B; //�ο�
	static boolean used[]; // ��� ī�� üũ
	static int win;
	static int lose;
	static int N=9;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			A = new int[9];
			B = new int[9];
			used = new boolean[19];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 9; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				used[A[i]] = true;
			}
			 
			int j=0;
			for (int i = 1; i < 19; i++) {
				if(used[i]) continue;
				B[j++] = i; // �ο��� ī�� ���� ���� 
			}
			//�ο��� ���� ����
			Arrays.sort(B);
			win = 0;
			lose = 0;
			do {
				//����
				int sumA = 0, sumB = 0;
				for (int i = 0; i < 9; i++) {
					//A�� �̱�� ���
					if(A[i] > B[i]) sumA += A[i] + B[i];
					//A�� ���� ���
					if(A[i] < B[i]) sumB += A[i] + B[i];
				}
				if (sumA > sumB) {
					win++;
				}else {
					lose++;
				}
			}while(np());

			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		} // end of test case
		System.out.print(sb);
	}// end of main
	
	public static boolean np() {
		int i = N-1;
		while(i > 0 && B[i-1] >= B[i]) --i;
		if(i==0) return false;
		
		int j = N-1;
		while(B[i-1] >= B[j]) --j;
		swap(i-1,j);
		
		int k = N-1;
		while(i < k) {
			swap(i++, k--);
		}
		return true;
	}

	private static void swap(int i, int j) {
		int temp = B[i];
		B[i] = B[j];
		B[j] = temp;
	}

}
