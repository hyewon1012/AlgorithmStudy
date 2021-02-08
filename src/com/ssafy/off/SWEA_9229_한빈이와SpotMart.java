package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * ���� �κ��� �ִ� ���� ��
 * 1. �ִ� M�׷� �̻�
 * 2. ���� �Ѱ��� �κ��� �����.
 */
public class SWEA_9229_�Ѻ��̿�SpotMart {
	static int answer;
	static int[] arr;
	static int MAX_WEIGHT;
	
	private static int solve(int idx, int cnt, int weight) {
		if(cnt < 2 && idx == arr.length) {
			return -1;
		}

		if(cnt == 2) {
			return weight;
		}
		
		//idx�� ������
		if(weight+arr[idx] <= MAX_WEIGHT) {
			answer = Math.max(solve(idx+1, cnt, weight), solve(idx+1, cnt+1, weight+arr[idx]));
		}
		//idx�� ���ø���
		else {
			answer = solve(idx+1, cnt, weight);	
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // ���ں�������
			MAX_WEIGHT = Integer.parseInt(st.nextToken()); //���� �� ����
			
			arr = new int[N]; // N�� ���� �κ��� ���� �迭
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			answer = -1;
			int ans = solve(0,0,0);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
			
		} // end of Test Case
		System.out.print(sb);
		
	}// end of main
}// end of class