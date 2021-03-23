package com.ssafy.off;

import java.util.Arrays;

public class Algo_DP_��������1 {

	public static void main(String[] args) {
		//dp[n] : n���� ��ĥ�Ҽ��ִ� ����� ��
		//dp[n] = dp[n-1]*2-(n-2) �Ķ��� �����ϴ°�� �ϳ� ���ֱ�
		//����� ������ ���� ����
		//�Ķ��� ������ ���� �Ұ���
		int[] dp = new int[1001];
		Arrays.fill(dp, -1);
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= 1000; i++) {
			dp[i] = dp[i-1]*2-(i-2);
		}
		System.out.println(dp[8]);

		solve();
	}
	
	private static void solve() {
		int N = 8;
		int[][] dp = new int[N+1][2];
		dp[1][0] = 1; // 1������ ����� �� �ִ� ����� ����Ǽ�
		dp[1][1] = 1; // 1������ ����� �� �ִ� �Ķ��� ����Ǽ�
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i-1][0]+dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		System.out.println(dp[8][0]+dp[8][1]);
	}

}
