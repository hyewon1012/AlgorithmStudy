package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_20304_��й�ȣ���� {
	static int N,M,result = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // ������ ���� �ִ밪
		M = Integer.parseInt(br.readLine()); // ��Ŀ�� �õ��� �н����� ����
		int[] attack = new int[M]; // ��Ŀ�� ����� �н����� ����Ʈ
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			attack[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			int safeDistance = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) { // �����Ÿ� ���
				int tmp = 0; // ���� �ٸ� ��Ʈ �� ����� ����
				tmp = countDiffBit(i, attack[j]);
				safeDistance = Math.min(safeDistance, tmp);
			}
			result = Math.max(safeDistance, result);
		}
		System.out.println(result);
	}
	//��� ������ �н����� �ĺ��� ��Ŀ�� ����� �н����带 ���ϸ鼭 �����Ÿ� ����ϱ�
	private static int countDiffBit(int admin, int hacker) {
		int tmp = admin ^ hacker; // ���������� ���� ��Ʈ ������ ������ �Ѵ�. -> ���� �ٸ� ��Ʈ�� 1�� ����.
		int cnt = 0;
		
		char[] s = Integer.toBinaryString(tmp).toCharArray();
		
		for (int i = 0; i < s.length; i++) {
			if(s[i] == '1') {
				cnt++;
			}
		}
		
		return cnt;
	}
	
}
