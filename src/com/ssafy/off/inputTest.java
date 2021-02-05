package com.ssafy.off;

import java.util.Arrays;
import java.util.Scanner;

public class inputTest {
	//입력이 공백이없고
	//11110111
	//00001001
	//이런식일때
	public static void charPrint(int[][] map) {
		Scanner sc = new Scanner(System.in);
		int N = map.length;
		for (int i = 0; i < N; i++) {
			char[] tmp = sc.next().toCharArray(); //한 행을 위한 배열
			for (int j = 0; j < N; j++) {
				//char타입의 숫자 -> int타입
				map[i][j] = tmp[j] -'0';
			}
		}
	}
	public static void print() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); //테스트 케이스
		
		for (int t = 1; t <= tc; t++) {
			String[][] map = new String[100][100];
			
			//행 단위입력
			for (int x = 0; x < 100; x++) {
				map[x] = sc.nextLine().split(" ");
			}
			
			//확인
			System.out.println(Arrays.deepToString(map));
		}
	}
}
