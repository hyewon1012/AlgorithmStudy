package com.ssafy.off;

public class Algo_DP_��������2 {

	public static void main(String[] args) {
		
		int N = 6;
		//1. ���ؾ� �Ǵ� ���� �������� �Ẹ��. �Լ��� ������ ��Ȯ�ϰ� ����
		int[] dp = new int[N+1];
		dp[1] = 2;
		dp[2] = 5;
		for (int i = 3; i <= N; i++) {
			//��ü ���̰� N�� ��� �� �ڿ� ���,�Ķ�,������ �� ���
			dp[i] = dp[i-1] + dp[i-1] + dp[i-2];
		}
		System.out.println(dp[N]);
	}

}
