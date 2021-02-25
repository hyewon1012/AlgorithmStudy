package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15684_사다리조작 {
	static int[][] ladder;
	static int Col,Row,H;
	static int ans=4;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		Col = Integer.parseInt(s[0]);
		Row = Integer.parseInt(s[1]);
		H = Integer.parseInt(s[2]);
		ladder = new int[Col+1][Row+1];
		
		for (int i = 0; i < Row; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ladder[x][y] = 1;
		}
		setLine(0,0,0);
		ans = ans > 3 ? -1 : ans;
		System.out.println(ans);

	}
	//x:세로 y:가로
	private static void setLine(int cnt, int x, int y) {
		if(ans <= cnt) return;
		if(cnt == 3) {
			return;
		}
		//사다리 타기 체크
		boolean flag = true;
		for (int i = 1; i <= Col; i++) {
			int now = i;
			for (int j = 1; j <= H; j++) {
				if(ladder[j][now] == 1) {
					now += 1;
				}//연결안돼있으면 왼쪽확인
				else if(ladder[j][now-1] == 1 && now > 0) {
					now -= 1;
				}
				if(i != now) flag = false;
			}
		}
		if(flag) {
			if( ans > cnt) {
				ans = cnt;
			}
			return;
		}
		
		for (int i = x; i <= Col; i++) {
			for (int j = y; j <= Row; j++) {
				if(ladder[i][j] == 1) {
					j++; //가로 연속해서 놓는거 불가능
				}else {
					ladder[i][j] = 1;
					setLine(cnt+1, i, j+2);
					ladder[i][j] = 0;
				}
			}
		}

	}

}
