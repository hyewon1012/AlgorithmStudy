package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_마법사상어와파이어볼_20056 {
	static int N;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[][] map;
	static List<Integer[]> pos; // y, x, 질량, 속력, 방향
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		N = Integer.parseInt(init[0]); // 맵 크기
		int M = Integer.parseInt(init[1]); // 파이어볼 개수
		int K = Integer.parseInt(init[2]); // 명령어 횟수
		
		pos = new ArrayList<Integer[]>();
		map = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Integer[] temp = new Integer[5];
			for (int j = 0; j < 5; j++) {
				int val = Integer.parseInt(st.nextToken());
				temp[j] = val;
			}
			pos.add(temp);
			
		}
		//K번 이동
		move();
		
		
	} // end of main
	
	//모든 파이어볼 명령어 한번씩 수행하고 옮겨진 좌표 리턴
	private static List<Integer[]> move() {
		List<Integer[]> after = new ArrayList<Integer[]>();
		for (int i = 0; i < pos.size(); i++) {
			Integer[] info = pos.get(i);
			
			int m = info[2];
			int s = info[3];
			int d = info[4];
			
			int ny = (info[0] + dy[d]*s)%N;
			int nx = (info[1] + dx[d]*s)%N;
			
			Integer[] afterInfo = {ny,nx,m,s,d};
			after.add(afterInfo);
		}
		//같은좌표에 있는 파이어볼 번호
		Set<Integer> ball = new HashSet<Integer>();
		for (int i = 0; i < after.size(); i++) {
			for (int j = 0; j < after.size(); j++) {
				if(i==j) continue;
				if(after.get(i)[0] == after.get(j)[0] && after.get(i)[1] == after.get(j)[1]) {
					//같은좌표
					ball.add(i+1);
				}
			}
		}
		Iterator<Integer> iter = ball.iterator();
		
		return after;
	}

}
