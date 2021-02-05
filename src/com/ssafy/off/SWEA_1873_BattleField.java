package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_1873_BattleField {
	//������ �� �ϳ�
	//��ź �߻��ϸ� ���� �浹�ϰų� ���� �� ������ ���������� �����Ѵ�. -> ���� �� ������ ��ź�� ������ �ƹ��ϵ�����.
	//��ź�� ���� �ε����� ��ź�� ������� ��ö ���� �״�� ���� ���� ������ �ٲ��.
	//��ȭ�� �� ���� ���
	static char[][] map;
	static char[] input;
	static char[] tank = {'^','v','<','>'};
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static HashMap<Character, Integer> order = new HashMap<>();
	
	public static void init() {
		order.put('U', 0);
		order.put('D', 1);
		order.put('L', 2);
		order.put('R', 3);
	}
	//��ɾ��� �̵�
	//map���� ��ȭ
	public static void solve(int y, int x, int dir, char[][] map, char[] input) {//dir : ��ũ �ʱ� ����
		int py,px; //�ʱ� ��ũ ��ġ
		int next_dir = dir;
		py = y;
		px = x;
		for (int i = 0; i < input.length; i++) {
			if(input[i] == 'S') {
				//��ź �߻� : ��ź�� ������� ��ö��(#)�� �״�� ������(*)�� �����ιٲ�
				//�����ε����� �ʹ����γ�����
				int p_y = py; //��ź y ��ġ
				int p_x = px; //��ź x ��ġ
				while(true) {
					int ny = p_y + dy[next_dir];//�����̹ٲ��������Ѿ���
					int nx = p_x + dx[next_dir];
					if(ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length) {
						//��ö���� �ε�����
						if(map[ny][nx] == '#') {
							break;
						}
						//�������� �ε�����
						else if(map[ny][nx] == '*') {
							map[ny][nx] = '.';//�����ιٲ��.
							break;
						}
						//��� �̵�
						else {
							p_y = ny;
							p_x = nx;
						}
					}else {
						//�ʹ����γ����� �� ��ȭ ����
						break;
					}
				}
			//���� ��ɾ��϶�
			}else {
				//��ĭ���� �̵�
				int ny = py + dy[order.get(input[i])];
				int nx = px + dx[order.get(input[i])];
				next_dir = order.get(input[i]);
				map[py][px] = tank[next_dir]; //������ǥ�� ��ũ ���� ���� ����
				if(ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length) {
					if(map[ny][nx] == '.') {
						map[py][px] = '.'; //������ġ�����ιٲ�
						map[ny][nx] = tank[next_dir];
						py = ny;
						px = nx;
					}
				}
				
			}

			
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= tc; t++) {
			//�Է�
			StringTokenizer st = new StringTokenizer(in.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			int startY=0,startX=0;
			int dir = -1;
			
			map = new char[row][col];
			for (int i = 0; i < row; i++) {
				String line = in.readLine();
				for (int j = 0; j < col; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						startY = i;
						startX = j;
						for (int k = 0; k < 4; k++) {
							if(tank[k] == map[i][j])
								dir = k;
						}
					}
				}
			}
			int size = Integer.parseInt(in.readLine());

			input = in.readLine().toCharArray();
			
			init();
			
			solve(startY, startX, dir, map, input);
			System.out.print("#"+t+ " ");
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			

		}
		
	}

}
