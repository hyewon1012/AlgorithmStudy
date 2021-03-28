package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1242_소풍 {
	static int N,K,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // K번째 퇴장
		M = Integer.parseInt(st.nextToken()); //동호 번호
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		int cnt=0;
		while(!q.isEmpty()) {
			int out;
			for (int i = 1; i <= K; i++) {
				out = q.poll();
				if(i!=K) {
					q.add(out);
				}else {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
