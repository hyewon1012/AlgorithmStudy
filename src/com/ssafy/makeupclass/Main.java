package com.ssafy.makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 신청한 팀의 수 (1<=N<=500,000)
		int S = Integer.parseInt(st.nextToken()); // (0<=S<=12,000) 
		int M = Integer.parseInt(st.nextToken()); // (0<=M<=4,000)
		
		int cnt =0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			st = new StringTokenizer(line, " ");
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			
			if(x1 < M || x2 < M || x3 < M || x1 + x2 + x3 < S) { // 능력치 미달인 경우
				continue;
			}
			cnt++;
			
			sb.append(line).append(" ");
		}
		System.out.println(cnt); // sb 앞에 삽입하는 연산도있지만 내부적으로 shift 연산이 있기 때문에 이 방식이 더 효율적.
		System.out.print(sb);
		
	} // end of main

} // end of class
