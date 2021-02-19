package com.ssafy.makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2615 {
	private static int winColor = 0;
	private static int[][] m;
	private static int[] dy = {-1, 0, 1, 1}; //���, ��, ����, ��
	private static int[] dx = {1, 1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = new int[19+2][19+2]; // �迭�� ��� �������� 1�� ���
		for (int i = 1; i <= 19; i++) { //0���� �Ⱦ�, 1~19
			String line = br.readLine();
			for (int j = 1, index=0; j <= 19; j++, index += 2) {
				m[i][j] = line.charAt(index) - '0';
			}
		}
		for (int r = 1; r <= 19; r++) { //��
			for (int c = 1; c <= 19; c++) { // ��
				if(m[r][c] == 0) continue; // ���� �������� ������, ����ĭ���� �Ѿ��.
				//�������� Ȯ��
				if(complete(r,c)) {
					System.out.println(winColor);
					System.out.println(r + " " + c);
					return; // ���α׷� ����
				}
				
			}
			
		}
		System.out.println(0); //�¸��� �������� ���ϴ� ���
		
	} // end of main
	/** r,c ��ǥ���� �����ϴ� ������ �Ǵ��� Ȯ���ϰ�, �����̸� true �ƴϸ� false */
	private static boolean complete(int r, int c) {
		int color = m[r][c];
		dir:for (int k = 0; k < 4; k++) { // 4���� ���� ����
			
			//���� ĭ�� �ٸ� ������ Ȯ��
			if(m[r-dy[k]][c-dx[k]] == color) {
				continue;
			}
			//�������� Ȯ��
			for (int i = 1; i < 5; i++) {
				if(m[r + dy[k]*i][c + dx[k]*i] != color) { //���� ���̾����
					continue dir; // ���� �������� �Ѿ��
				}
			}
			//���� ĭ�� �ٸ� ������ Ȯ��
			if(m[r+dy[k]*5][c+dx[k]*5] == color) {
				continue;
			}
			//�̶��� ����.
			winColor = color;
			return true;
		}// end of for k
		return false;
	}

} // end of class
