package com.ssafy.dp;

import java.util.Scanner;

/*
 * �÷��̵� : ��� ���� ���� �ּҺ��
 * ����ġ ������ ���, ����Ŭ�� �������.
 * for 3�� ��� (������!!)
 * for - ������
 * 		for - �����
 * 			for - ������ 
 * */
/*
5
0 4 2 5 0
0 0 1 0 4
1 3 0 1 2
-2 0 0 0 2
0 -3 3 1 0
*/
public class FloydTest {
	static final int INF = 999;
	static int N, A, adjMatrix[][];
	static String src = "5\r\n" + 
			"0 4 2 5 0\r\n" + 
			"0 0 1 0 4\r\n" + 
			"1 3 0 1 2\r\n" + 
			"-2 0 0 0 2\r\n" + 
			"0 -3 3 1 0";
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		N = sc.nextInt();
		adjMatrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = sc.nextInt();
				if(i != j && adjMatrix[i][j] == 0) { // ���������� ���� ��� (������ �ȵ��ִ°��)
					adjMatrix[i][j] = INF;//����� �������̶� �� ����� 0�� �Ǵ� ��찡 �ֱ� ������ �����ؾ���
				}
			}
		}
		print();
		
		for (int via = 0; via < N; via++) {//������
			for (int from = 0; from < N; from++) {//�����
				if(via == from) continue;
				for (int to = 0; to < N; to++) {//������
					if(from == to || via == to) continue;
					adjMatrix[from][to] = Math.min(adjMatrix[from][to], adjMatrix[from][via]+adjMatrix[via][to]);
				}
			}
			print();
		}
		
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adjMatrix[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
	}

}
