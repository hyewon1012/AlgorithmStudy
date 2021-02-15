package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_�Կ��̿��ο�����ī����� {
/**
 * �Կ��� ī�� �Է¹���.(18�忡�� �Կ��� ī�� ���� �ο���ī��) 
 * �̶� �ο��̰� ī���� ������ ��� �ϴ��Ŀ� ���� �Կ��̰� �̱�� ���, ���� ��� ���?
 * @throws IOException 
 * @throws NumberFormatException 
 * */
	static int[] A; //�Կ�
	static int[] B; //�ο�
	static boolean used[]; // ��� ī�� üũ
	static boolean isSelected[]; // ���� ������ ��� ���� üũ
	static int[] result;
	static int win;
	static int lose;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			A = new int[9];
			B = new int[9];
			used = new boolean[19];
			isSelected = new boolean[9];
			result = new int[9];
			win = 0;
			lose = 0;
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
			permutation(0);
			
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		} // end of test case
		System.out.print(sb);
	}// end of main

	private static void permutation(int cnt) {
		if(cnt == 9) {
			//System.out.println(Arrays.toString(result));
			//����
			int sumA = 0, sumB = 0;
			for (int i = 0; i < 9; i++) {
				//A�� �̱�� ���
				if(A[i] > result[i]) sumA += A[i] + result[i];
				//A�� ���� ���
				if(A[i] < result[i]) sumB += A[i] + result[i];
			}
			if (sumA > sumB) {
				win++;
			}else {
				lose++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(isSelected[i]) continue;
			result[cnt] = B[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

}
