package com.ssafy.off;

import java.util.Arrays;
import java.util.Scanner;

public class inputTest {
	//�Է��� �����̾���
	//11110111
	//00001001
	//�̷����϶�
	public static void charPrint(int[][] map) {
		Scanner sc = new Scanner(System.in);
		int N = map.length;
		for (int i = 0; i < N; i++) {
			char[] tmp = sc.next().toCharArray(); //�� ���� ���� �迭
			for (int j = 0; j < N; j++) {
				//charŸ���� ���� -> intŸ��
				map[i][j] = tmp[j] -'0';
			}
		}
	}
	public static void print() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); //�׽�Ʈ ���̽�
		
		for (int t = 1; t <= tc; t++) {
			String[][] map = new String[100][100];
			
			//�� �����Է�
			for (int x = 0; x < 100; x++) {
				map[x] = sc.nextLine().split(" ");
			}
			
			//Ȯ��
			System.out.println(Arrays.deepToString(map));
		}
	}
}
