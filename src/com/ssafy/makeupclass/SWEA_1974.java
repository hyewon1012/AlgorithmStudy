package com.ssafy.makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 *�Է�ó��
 *���࿡ 1 ~ 9 ���Ǿ����� Ȯ��?
 */
public class SWEA_1974 {
	
	private static int[][] map;
	static boolean[] flag = new boolean[10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		map = new int[9][9]; // �� �� ���� ����
		for (int t = 1; t <= TC; t++) {
			for (int i = 0; i < 9; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < 9; j++, index += 2) {
					map[i][j] = s.charAt(index) - '0';
				}
			}
			sb.append("#").append(t).append(" ").append(check()).append("\n");
		} //end of for testCase
		System.out.print(sb);
	} // end of main
	
	/** �ش� ������ �������� �������� Ȯ���ϴ� �޼���*/
	public static int check() {
		for (int i = 0; i < 9; i++) {
			if(!checkRow(i) || !checkCol(i)) { // �����̸� true �������̸� false
				return 0; // ����
			}
		}
		for (int i = 0; i < 9; i+=3) {
			for (int j = 0; j < 9; j+=3) {
				if(!checkBlock(i,j)) {
					return 0;
				};
			}
		}
			
		return 1; // ����
	}
	
	/** 3*3 ����� ���� ��ȿ���� üũ, �����̸�  true, ������ false ����*/
	private static boolean checkBlock(int r, int c) {
		Arrays.fill(flag, false);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(flag[map[r+i][c+j]]) {
					return false;
				}
				flag[map[r+i][c+j]] = true;
			}
		}
		return true;
	}

	/** r ���� ���� ��ȿ���� üũ, �����̸� true, ������ false ����*/
	private static boolean checkRow(int r) {
		Arrays.fill(flag, false);
		for (int i = 0; i < 9; i++) {
			if(flag[map[r][i]]) {
				return false;
			}
			flag[map[r][i]] = true;
		}
		return true; // ����
	}
	
	/** c ���� ���� ��ȿ���� üũ, �����̸� true, ������ false ����*/
	private static boolean checkCol(int c) {
		Arrays.fill(flag, false);
		for (int i = 0; i < 9; i++) {
			if(flag[map[i][c]]) {
				return false;
			}
			flag[map[i][c]] = true;
		}
		return true; // ����
	}
}// end of class
