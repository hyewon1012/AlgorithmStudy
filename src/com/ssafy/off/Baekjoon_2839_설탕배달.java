package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * �����ּҰ���
 * dp[n] : nų�α׷� ����ϴµ� 3kg,5kg ���� �ּ� ���� ��
 * dp[0] = 0
 * dp[3] = 1
 * dp[5] = 1
 * */
public class Baekjoon_2839_������� {
	
	static int answer = 0;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int N = Integer.parseInt(br.readLine());
		dp = new int[5001];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[3] = 1;
		dp[5] = 1;
		
		if(N <= 5) {
			System.out.println(dp[N]);
		}else {
			for (int i = 6; i <= N; i++) {
				if(dp[i-3] != -1 && dp[i-5] != -1) {
					dp[i] = Math.min(dp[i-3],dp[i-5])+1;
				}
				if(dp[i-3] != -1 && dp[i-5] == -1) {
					dp[i] = dp[i-3] + 1;
				}
				if(dp[i-3] == -1 && dp[i-5] != -1) {
					dp[i] = dp[i-5] + 1;
				}
				
			}
			System.out.println(dp[N]);
		}
		


	}


}
