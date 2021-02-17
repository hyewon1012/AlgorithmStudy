package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2961_�����̰�������ִ����� {
/**
 * ��Ḧ ��� �ϳ��� ���
 * ���̸� �ּҷ� ����� �丮�� ���̰��� ���
 * */
	static int N;
	static int[] sour;
	static int[] bitter;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		answer = Integer.MAX_VALUE;
		subset(1<<N);
		System.out.println(answer);
	}
	
	//�κ�����
	private static void subset(int caseCount) {
		for (int i = 0; i < caseCount; i++) {
			int s=1;//�Ÿ���
			int b=0;//������
			for (int j = 0; j < N; j++) {
				if((i & 1 << j)!=0) {
					s*=sour[j];
					b+=bitter[j];
					answer = Math.min(answer, Math.abs(s-b));
				}
			}
		}
	}
	
	

}
