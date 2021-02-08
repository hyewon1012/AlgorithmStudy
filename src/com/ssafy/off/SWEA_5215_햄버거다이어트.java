package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_�ܹ��Ŵ��̾�Ʈ {
	/**
	 * ���� ��ȣ�ϴ� �ܹ��� ���� && Į�θ� ����
	 * (���� ��Ḧ ������ ����Ҽ�����.) 
	 */
	static int N;
	static int Kalorie;
	static int answer;
	static int info[][];
	
	private static int find(int idx, int score, int remain) {
		if( remain < 0 ) return 0; // ���� ���� �ȵ�
		if( remain == 0) return score;
		if( idx == N ) return score; // ��� ��Ḧ ���� ����µ� ���
		
		int v1 = find(idx+1, score, remain); // �� ���� ��� �����Ϸ���
		int v2 = find(idx+1, score + info[idx][0], remain - info[idx][1]);
		
		return Math.max(v1, v2);
	}
	
	public static int solve(int idx, int score, int kalorie) {
		if (idx == N || kalorie == Kalorie) {
			return score;
		}
		else {
			//idx �����Ҽ�����
			if(kalorie + info[idx][1] <= Kalorie) {
				answer = Math.max(solve(idx+1, score + info[idx][0], kalorie + info[idx][1]), solve(idx+1, score, kalorie));
			}else {
				answer = solve(idx+1, score, kalorie);
			}
		}
		return answer;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			
			String[] data = br.readLine().split(" ");
			
			N = Integer.parseInt(data[0]);
			Kalorie = Integer.parseInt(data[1]);
			info = new int[N][2]; //��(0),Į�θ�(1) ���� �迭
			answer = -1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				info[i][0] = Integer.parseInt(st.nextToken()); 
				info[i][1] = Integer.parseInt(st.nextToken());
			}
			answer = solve(0, 0, 0);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);

	}

}
