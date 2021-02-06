package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int y;
	int x;
	int dir;
	Pos(int y, int x, int dir){
		this.y = y;
		this.x = x;
		this.dir = dir;
	}
}

public class BAEKJOON_14503_�κ�û�ұ� {
/**
 * 0 1 2 3 
 * 1. ������ġ û��
 * 2. ������ġ���� ���� ���� �������� ���ʹ������ ���ʴ�� Ž��!!! ���Ž�� ���⼭ �������ش�
 * 2-1. ���ʹ��⿡ û���Ҽ��ִ� ���� -> �� �������� ȸ���ϰ� ��ĭ �����ϰ� 1�� ���� ����
 * 2-2. ���ʹ��⿡ û�Ұ������� -> �� �������� ȸ���ϰ� 2������ ���ư�.
 * 2-3. �� ���� ��� û�ҵ� || �� ���� ��� �� -> ���� �����ϰ� ��ĭ �����ϰ� 2������ ���ư�
 * 2-4. �׹��� ��� û�ҵ� && �׹����κ� && �ڵ����̶� �������� -> end
 *  
 */
	//�� �� �� ��
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	
	static int[][] map;

	//�κ�û�ұⰡ û���ϴ� ĭ�� ����
	public static void clean(int y, int x, int dir) {

		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(y,x,dir));
		map[y][x] = 2;
		while(!q.isEmpty()) {
			Pos now = q.poll();
			
			int cleanCnt=0;
			int nowY = now.y;//����y
			int nowX = now.x;//����x
			int nowDir = now.dir;//�������
			int ny,nx,nd;
			for (int k = 0; k < 4; k++) {
				nowDir = (nowDir + 3) % 4; //dir�� ������� ���� Ž���� �����̵ȴ�.
				ny = nowY + dy[nowDir];
				nx = nowX + dx[nowDir];
				
				if(ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length) {
					//���� û���Ҽ�����
					if(map[ny][nx] == 0) {
						//System.out.println("(" +ny+" , "+nx + ") dir : "+nowDir);
						//���� ȸ���ϰ� -> ��ĭ ���� -> �ٲ� ���� �ٽ� next�� �־���
						q.add(new Pos(ny, nx, nowDir));
						map[ny][nx] = 2;
						break;//ó������ ����
					}else {
						cleanCnt++;
					}
				}
			}//���Ž����
			//�� ���� ���Ž��������
			if(cleanCnt == 4) {
				nd = (nowDir + 2) % 4;
				ny = nowY + dy[nd];
				nx = nowX + dx[nd];
				
				//�����Ѱ��� ���� �ƴϸ� ��� ����
				//���� �����ϰ� �����ϰ� 2������ ���ư�
				if(map[ny][nx] != 1) {
					q.add(new Pos(ny, nx, nowDir));
					map[ny][nx] = 2;
				}
			}
			
		}
		
	}
	
	//�Է������ϱ�
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ROW = Integer.parseInt(st.nextToken());
		int COL = Integer.parseInt(st.nextToken());
		
		String[] pos = br.readLine().split(" ");
		int startY = Integer.parseInt(pos[0]);
		int startX = Integer.parseInt(pos[1]);
		int startDir = Integer.parseInt(pos[2]);
		
		map = new int[ROW][COL];
		
		
		for (int i = 0; i < ROW; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < COL; j++) {
				map[i][j] = Integer.parseInt(s.nextToken());
			}
		}
		
		//solve
		int answer=0;
		clean(startY, startX, startDir);
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if(map[i][j] == 2) {
					answer++;
				}
			}
		}
		sb.append(answer);
		System.out.print(sb);
	}

}
