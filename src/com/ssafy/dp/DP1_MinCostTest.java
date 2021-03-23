package com.ssafy.dp;

import java.util.Arrays;
import java.util.Scanner;

public class DP1_MinCostTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] dp = new int[money+1]; // 각 금액에 대한 동전 최소 개수
		
		dp[0] = 0;
		for (int i = 1; i <= money; i++) {
			int min = Integer.MAX_VALUE;
			if(dp[i-1]+1 < min) min = dp[i-1]+1;
			if(i>=4 && dp[i-4]+1 < min) min = dp[i-4]+1;
			if(i>=6 && dp[i-6]+1 < min) min = dp[i-6]+1;
			dp[i] = min;
		}
		System.out.println(dp[money]);
		System.out.println(Arrays.toString(dp));
	}

}
