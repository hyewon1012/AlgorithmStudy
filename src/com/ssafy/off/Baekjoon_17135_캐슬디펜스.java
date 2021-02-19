package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Enemy {
	int y;
	int x;
	public Enemy(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}
class Archer {
	int y;
	int x;

	public Archer(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}

class ShortestAndLeft implements Comparable<ShortestAndLeft>{
	int y;
	int x;
	int distance;
	
	public ShortestAndLeft(int y, int x, int distance) {
		this.y = y;
		this.x = x;
		this.distance = distance;
	}

	@Override
	public int compareTo(ShortestAndLeft o) {
		//�Ÿ� �����ͺ��� (������������)
		int dist = this.distance - o.distance;
		if(dist == 0) {
			//���� ���ʿ� �ִ°�(������������)
			return this.x - o.x;
		}
		return dist;
	}
	
}

public class Baekjoon_17135_ĳ�����潺 {
/**
 * N*M N�� �ؿ��� ��� ��
 * 1. �� �ϸ��� �ü� �� �Ѹ� ����. �Ÿ��� D������ �� �߿��� ���� ����� ��. ���� ���ʿ� �ִ� �� ����
 * 2. �� �Ʒ��� ��ĭ �̵�
 * 3. ��� ���� �����ǿ��� ���ܵǸ� ���ӳ�
 * �ü��� �������� �����Ҽ��ִ� ���� �ִ� ��.
 * �ü� 3�� ��ġ ���� -> �ü� 3�� ��ġ ��ġ �ε��� ����-> �ִ밪 ã��
 * */
	static int N,M,D;
	static int[][] map;
	static int[][] copyMap;
	static boolean[] visited;
	static ArrayList<Enemy> enemy;
	static ArrayList<Archer> archer;
	static int ans =Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		M = Integer.parseInt(info[1]);
		D = Integer.parseInt(info[2]);
		
		map = new int[N+1][M];
		copyMap = new int[N+1][M];
		visited = new boolean[M];
		enemy = new ArrayList<Enemy>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copyMap[i][j] = map[i][j]; // �ʱ� ����
				if(map[i][j] == 1) {
					enemy.add(new Enemy(i, j));
				}
			}
		}
		
		setArcher(0,0);
		solve();
		System.out.println(ans);

	}
	
	//�ü���ġ -> 2�����迭 ����
	private static void setArcher(int cnt, int idx) {
		
		if(cnt == 3) {
			//����
			archer = new ArrayList<Archer>();
			for (int i = 0; i < M; i++) {
				if(visited[i]) {
					archer.add(new Archer(N, i));
				}
			}
			solve();
			
			return;
		}
		for (int i = idx; i < M; i++) {
			if(visited[idx]) continue;
			visited[idx] = true;
			setArcher(cnt+1, idx+1);
			visited[idx] = false;
		}

	}
	
	private static void solve() {
		int kill = 0;
		int line = N;
		
		while(line > 0) {
			ArrayList<Enemy> killList = new ArrayList<Enemy>();
			PriorityQueue<ShortestAndLeft> pq = new PriorityQueue<ShortestAndLeft>();
			//�ü����� �� Ž��
			for (Archer arch : archer) {
				for (Enemy e : enemy) {
					int dist = Math.abs(arch.y-e.y) + Math.abs(arch.x-e.x);

					if(dist <= D) {
						//1. ���尡���� 			
						//2. x��ǥ ��������ΰ�
						pq.add(new ShortestAndLeft(e.y, e.x, dist));
					}
				}
				
				if(!pq.isEmpty()) {
					ShortestAndLeft shortest = pq.poll();
					int y = shortest.y;
					int x = shortest.x;
					killList.add(new Enemy(y, x));
				}
			}
			//���
			for (int i = 0; i < killList.size(); i++) {
				int y = killList.get(i).y;
				int x = killList.get(i).x;
				if(copyMap[y][x] == 1) {
					copyMap[y][x] = 0;
					kill += 1;
				}
				
			}
			//�Ʒ��� ��ĭ ������
			for (int i = N-2; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					copyMap[i+1][j] = copyMap[i][j];
				}
			}
			for (int i = 0; i < M; i++) {
				copyMap[0][i] = 0;
			}
			ans = Math.max(ans, kill);
			line--;
		}
	}
	
}
