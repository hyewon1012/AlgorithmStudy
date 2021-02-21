package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Baekjoon_15686_ġŲ��� {
/**
 * ġŲ �Ÿ� : ���� ���� ����� ġŲ�� �Ÿ�
 * ������ ġŲ�Ÿ��� ���� ���� ġŲ�� �ִ� M�� ����.
 * ������ ġŲ �Ÿ��� ���� ���� ���� ã�� (�ִ� M��) �־��� ġŲ���� 1,2,...M�� �̴´�
 * */
	static int[][] map;
	static int N;
	static int R;
	static ArrayList<Chiken> chiken;
	static ArrayList<Home> home;
	static ArrayList<Chiken> selected;
	static int[] flag;
	
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] init = br.readLine().split(" ");
		N = Integer.parseInt(init[0]);
		R = Integer.parseInt(init[1]); // ġŲ�� ����
		chiken = new ArrayList<Chiken>(); // ġŲ�� ��ǥ
		map = new int[N][N];
		selected = new ArrayList<Chiken>(); // ������ ġŲ�� ����Ʈ
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
		//ġŲ�� R��
		//�����Ű�� ���� ġŲ�� 0�� 1�� 2�� -> � �ϴ� ġŲ������ 1,2,.. �ִ� R��
		int dist = Integer.MAX_VALUE; //��� �ּ� ġŲ�Ÿ�
		for (int i = 1; i <= chiken.size(); i++) {
			int cnt = 0;
			flag = new int[i];
			while(++cnt <= i) flag[i-cnt]=1;
			do {
				int distSum = 0; // ���ո��� ������ ġŲ�Ÿ�
				for (int j = 0; j <= i; j++) {
					int singleDistance = Integer.MAX_VALUE;
					if(flag[j]==1) {
						//����
						for (Home h : home) {
							singleDistance = Math.min(singleDistance, Math.abs(h.y-chiken.get(j).y) + Math.abs(h.x-chiken.get(j).x));
						}
					}
					distSum += singleDistance;
				}
				dist = Math.min(dist, distSum);
			}while(np());
		}
		System.out.println(dist);
		
	}
	
	public static boolean np() {
		int i = chiken.size()-1;
		while(i > 0 && flag[i-1] >= flag[i] ) --i;
		
		if(i==0) return false;
		
		int j = chiken.size()-1;
		while(flag[i-1] >= flag[j]) --j;
		swap(i-1, j);
		
		int k = chiken.size()-1;
		while(i < k) {
			swap(i++, k--);
		}
		return true;		
	}
	
	private static void swap(int i, int j) {
		int temp = flag[i];
		flag[i] = flag[j];
		flag[j] = temp;
	}

}
