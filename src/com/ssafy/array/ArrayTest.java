package com.ssafy.array;

public class ArrayTest {
	static int[][] map = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
	};
	
	//����ȸ
	public static void columnOrder(int[][] map, int row, int col) {
		for (int x = 0; x < col; x++) {
			for (int y = 0; y < row; y++) {
				System.out.print(map[y][x]+" ");
			}
			System.out.println();
		}
	}
	//������� ��ȸ
	public static void zigzagOrder(int[][] map, int row, int col) {
		for (int y = 0; y < row; y++) {
			for (int x = 0; x < col; x++) {
				System.out.print(map[y][x+(col-1-2*x)*(y%2)]+" ");
			}
			System.out.println();
		}
	}
	//������� ��ȸ 2
	public static void zigzagOrder2(int[][] map, int row, int col) {
		for (int y = 0; y < row; y++) {
			if(y%2==0) {
				for (int x = 0; x < col; ++x) {
					System.out.print(map[y][x]+" ");
				}
			}else {
				for (int x = col-1; x >= 0; --x) {
					System.out.print(map[y][x]+" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("����ȸ");
		columnOrder(map, map.length, map[0].length);
		System.out.println("������׼�ȸ");
		zigzagOrder(map, map.length, map[0].length);
		System.out.println("������׼�ȸ2");
		zigzagOrder2(map, map.length, map[0].length);

	}

}
