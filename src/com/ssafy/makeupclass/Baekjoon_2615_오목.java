package com.ssafy.makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * ����Ž�� ������ : 19*19*4*7
 * */
public class Baekjoon_2615_���� {
/**
 * 19*19 �ٵ��� 5�� �������̸� �¸�
 * �¸� -> ���� ���ʿ��ִ� �ٵ��� row,col ���
 * ���ι��� ���ι��� �밢������ dfs.
 * basis case
 * 1. ���������� ������ ���� 5���϶� return 1 or 2(�ٵϻ���)
 * 2. ny, nx ���� ��
 * 3. cnt < 5 and �������� return 0 
 * */
	final static int N = 19;
	static int[][] map;
	//������, �Ʒ�, ������ �Ʒ� �밢��, ������ �� �밢��
	static int[] dy = {0,1,1,-1};
	static int[] dx = {1,0,1,1};
	
	static int ans;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		
		ans = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//solve
		
		int ansY = 0, ansX = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						solve(i,j,k,0);
						if(ans != -1) {
							ansY = i;
							ansX = j;
							System.out.println(ansY+1+" " + ansX+1);
							
						}
						
					}
					
				}
			}
		}
		
	}// end of main
	
	private static int solve(int y, int x, int dir, int cnt) {
//		if(cnt > 5) {
//			ans = 0;
//			return;
//		}
//		
		if(cnt >= 5) {
			//�ٵϾ˻���
			System.out.println(map[y][x]);
			ans = map[y][x];
			//�������� ��������..
			//�����Ǵ� �������� �������� �Ǵ�
			
			return cnt;
		}
		
		//dir�������� ��� �̵�
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if(ny < 0 || ny >= N || nx < 0 || nx >= N) return 0;
		
		//���� ��������� ������ �ٸ��� Ż��
		if(map[y][x] != map[ny][nx]) return 0;
		
		if(solve(ny,nx,dir,cnt++) == 5) {
			return cnt;
		}
		return 0;

	}

}
