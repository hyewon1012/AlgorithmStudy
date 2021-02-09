package com.ssafy.makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 *입력처리
 *한행에 1 ~ 9 사용되었는지 확인?
 */
public class SWEA_1974 {
	
	private static int[][] map;
	static boolean[] flag = new boolean[10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		map = new int[9][9]; // 한 번 만들어서 재사용
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
	
	/** 해당 스도쿠가 정상인지 오류인지 확인하는 메서드*/
	public static int check() {
		for (int i = 0; i < 9; i++) {
			if(!checkRow(i) || !checkCol(i)) { // 정상이면 true 비정상이면 false
				return 0; // 오류
			}
		}
		for (int i = 0; i < 9; i+=3) {
			for (int j = 0; j < 9; j+=3) {
				if(!checkBlock(i,j)) {
					return 0;
				};
			}
		}
			
		return 1; // 정상
	}
	
	/** 3*3 블록의 값이 유효한지 체크, 정상이면  true, 오류면 false 리턴*/
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

	/** r 행의 값이 유효한지 체크, 정상이면 true, 오류면 false 리턴*/
	private static boolean checkRow(int r) {
		Arrays.fill(flag, false);
		for (int i = 0; i < 9; i++) {
			if(flag[map[r][i]]) {
				return false;
			}
			flag[map[r][i]] = true;
		}
		return true; // 정상
	}
	
	/** c 열의 값이 유효한지 체크, 정상이면 true, 오류면 false 리턴*/
	private static boolean checkCol(int c) {
		Arrays.fill(flag, false);
		for (int i = 0; i < 9; i++) {
			if(flag[map[i][c]]) {
				return false;
			}
			flag[map[i][c]] = true;
		}
		return true; // 정상
	}
}// end of class
