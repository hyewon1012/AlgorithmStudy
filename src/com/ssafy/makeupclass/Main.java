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
		int N = Integer.parseInt(st.nextToken()); // ��û�� ���� �� (1<=N<=500,000)
		int S = Integer.parseInt(st.nextToken()); // (0<=S<=12,000) 
		int M = Integer.parseInt(st.nextToken()); // (0<=M<=4,000)
		
		int cnt =0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			st = new StringTokenizer(line, " ");
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			
			if(x1 < M || x2 < M || x3 < M || x1 + x2 + x3 < S) { // �ɷ�ġ �̴��� ���
				continue;
			}
			cnt++;
			
			sb.append(line).append(" ");
		}
		System.out.println(cnt); // sb �տ� �����ϴ� ���굵������ ���������� shift ������ �ֱ� ������ �� ����� �� ȿ����.
		System.out.print(sb);
		
	} // end of main

} // end of class
