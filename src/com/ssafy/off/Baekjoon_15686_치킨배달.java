package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
class Home{
	int y;
	int x;
	public Home(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
class Chiken{
	int y;
	int x;
	public Chiken(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Baekjoon_15686_치킨배달 {
/**
 * 치킨 거리 : 집과 가장 가까운 치킨집 거리
 * 도시의 치킨거리가 가장 적은 치킨집 최대 M개 고르기.
 * 도시의 치킨 거리가 가장 적은 조합 찾기 (최대 M개) 주어진 치킨집중 1,2,...M개 뽑는다
 * */
	static int[][] map;
	static int N;
	static int R;
	static ArrayList<Chiken> chiken;
	static ArrayList<Home> home;
	static ArrayList<Chiken> selected;
	static int[] result;
	static boolean[] visited;
	
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		N = Integer.parseInt(init[0]);
		R = Integer.parseInt(init[1]); // 치킨집 갯수
		chiken = new ArrayList<Chiken>(); // 치킨집 좌표
		map = new int[N][N];
		selected = new ArrayList<Chiken>(); // 선택한 치킨집 리스트
		home = new ArrayList<Home>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					home.add(new Home(i,j));
				}
				if(map[i][j] == 2) {
					chiken.add(new Chiken(i, j));
				}
			}
		}
		visited = new boolean[R];
		ans = Integer.MAX_VALUE;
		for (int i = 1; i <= R; i++) {
			
			solve(0,i,0);
		}
		System.out.println(ans);
		
	}
	private static void solve(int cnt, int size, int idx) {
		if(cnt == size) {
			System.out.println("크기 "+cnt);
			for (Chiken c : selected) {
				System.out.println(c.y + " " + c.x);
			}
			//구현
			int dist = Integer.MAX_VALUE;
			for (int i = 0; i < home.size(); i++) {
				int hy = home.get(i).y;
				int hx = home.get(i).x;
				for (int j = 0; j < selected.size(); j++) {
					int cy = chiken.get(j).y; 
					int cx = chiken.get(j).x;
					dist = Math.min(dist, (Math.abs(hy-cy)+Math.abs(hx-cx)));
				}
			}
			ans = Math.min(ans, dist);
			return;
		}
		for (int i = idx; i < chiken.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected.add(chiken.get(i));
				solve(cnt+1, size, idx+1);
				visited[i] = false;
				selected.remove(chiken.get(i));
			}
		}
		
	}

}
