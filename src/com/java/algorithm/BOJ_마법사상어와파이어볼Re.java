package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_마법사상어와파이어볼Re {
	static class Fireball{
		int y,x,m,s,d; // y x 질량 속도 방향
		
		public Fireball(int y, int x, int m, int s, int d) {
			super();
			this.y = y;
			this.x = x;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Fireball [y=" + y + ", x=" + x + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}
		
		
	}
	static int N, M, K;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static Queue<Fireball> q;
	static List<Fireball>[][] map;
	static int[][] deltas = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static int[] deltaSetA = { 0, 2, 4, 6 }, deltaSetB = { 1, 3, 5, 7 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		N = Integer.parseInt(init[0]); // 맵 크기
		M = Integer.parseInt(init[1]); // 파이어볼 개수
		K = Integer.parseInt(init[2]); // 명령어 횟수
		
		map = new ArrayList[N+1][M+1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		q = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			q.offer(new Fireball(y, x, m, s, d));
		}
		
		while(!q.isEmpty()) {
			if(K==0) break;
			int size = q.size();
			while(size-- > 0) {
				Fireball now = q.poll();
				//파이어볼 이동
				move(now);
				if(map[now.y][now.x].size() == 0) { // 이동 후 가는 지점이 비어있으면 내가 들어간다.
					map[now.y][now.x].add(now);
				}else {
					//다른 파이어볼 있으면 합치기
				}
			}// 이동 끝
			
			K--;
		}

	}
	private static void move(Fireball now) {
		int y = now.y;
		int x = now.x;
		int d = now.d;
		int s = now.s;
		now.y = ((now.y + dy[d]*s)%N + N)%N;
		now.x = ((now.x + dx[d]*s)%N + N)%N;
	}

}
