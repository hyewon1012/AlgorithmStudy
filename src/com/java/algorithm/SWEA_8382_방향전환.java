package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8382_방향전환 {
	static int ans;
	static int endX, endY;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			ans = Integer.MAX_VALUE;
			
			//가로이동 시작
			//solve(x1,y1,0,0);
			//세로이동 시작
			solve(x1,y1,1,0);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		} // end of test case
		System.out.print(sb);

	}

	private static int solve(int x1, int y1,int flag, int cnt) {
		
		if(x1 == endX && y1 == endY) {
			return cnt;
		}else {
			//이전이 가로이동이면 세로이동
			if(flag == 0) {
				if(x1 >= -100 && y1+1 <= 100) {
					solve(x1,y1+1,1,cnt+1);
				}
				if(x1 >= -100 && y1-1 <= 100) {
					solve(x1,y1-1,1,cnt+1);
				}
				
			}else { //이전에 세로이동이면 가로이동
				if(x1+1 >= -100 && y1 <= 100) {
					solve(x1+1,y1,0,cnt+1);
				}
				if(x1-1 >= -100 && y1 <= 100) {
					solve(x1-1,y1,0,cnt+1);
				}
				
			}
		}
		return -1;
		
	}

}
