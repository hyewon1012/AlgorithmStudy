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
class Fireball{
	int y,x,m,s,d; // y x 질량 속력 방향
	public Fireball(int y, int x, int m, int s, int d) {
		this.y=y;
		this.x=x;
		this.m=m;
		this.s=s;
		this.d=d;
	}
}
public class BOJ_마법사상어와파이어볼_20056 {
	static int N;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static List<Fireball>[][] map; //맵 정보
	static List<Fireball> pos = new ArrayList<Fireball>(); // 파이어볼 정보 리스트
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		N = Integer.parseInt(init[0]); // 맵 크기
		int M = Integer.parseInt(init[1]); // 파이어볼 개수
		int K = Integer.parseInt(init[2]); // 명령어 횟수
		
		map = new ArrayList[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pos.add(new Fireball(y, x, m, s, d));
		}
		//K번 이동
		for (int i = 0; i < K; i++) {
			move();
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (Fireball fb : map[i][j]) {
					ans += fb.m;
				}
			}
		}
		System.out.println(ans);
		
		
	} // end of main
	
	//모든 파이어볼 명령어 한번씩 수행하고 옮겨진 좌표 리턴
	private static void move() {
		
		for (Fireball ele : pos) {
			//음수나올때
//			int ny = ele.y + (dy[ele.d]*(ele.s%N))%N;
//			int nx = ele.x + (dx[ele.d]*(ele.s%N))%N;
			int ny = ele.y + dy[ele.d]*(ele.s%N);
			int nx = ele.x + dx[ele.d]*(ele.s%N);
			if(ny >= N) {
				ny = ny-N;
			}else if(ny < 0) {
				ny = ny + N;
			}
			if(nx >= N) {
				nx = nx-N;
			}else if(nx < 0) {
				nx = nx + N;
			}
			ele.y = ny;
			ele.x = nx;
			map[ny][nx].add(ele);
		}
		
		//같은좌표에 있는 파이어볼 번호 -> 어덯게 찾아주지?
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].size() > 1) {
					//합치기
					int s_sum=0, m_sum = 0;
					boolean even = true;
					boolean odd = true;
					for (Fireball fb : map[i][j]) {
						m_sum += fb.m;
						s_sum += fb.s;
						//방향 모두 홀수 or 모두 짝수 - > 0246 아니면 1357
						if(fb.d % 2 == 0) odd = false;
						if(fb.d % 2 == 1) even = false;
						
					}
					int new_m = m_sum / 5;
					int new_s = s_sum / map[i][j].size();
					map[i][j].clear();//합쳐진얘들은 원래있던 좌표에서 다 사라지게
					if(new_m > 0) {
						//추가
						for (int k = 0; k < 4; k++) {
							if(odd || even) {
								map[i][j].add(new Fireball(i, j, new_m, new_s, k*2));
							}else {
								map[i][j].add(new Fireball(i, j, new_m, new_s, k*2+1));
							}
						}
						
					}
					
				}
				
			}
		}
		
	}

}
