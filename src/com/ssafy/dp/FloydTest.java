package com.ssafy.dp;

import java.util.Scanner;

/*
 * 플로이드 : 모든 정점 간의 최소비용
 * 가중치 음수도 허용, 싸이클은 없어야함.
 * for 3개 사용 (경찰도!!)
 * for - 경유지
 * 		for - 출발지
 * 			for - 도착지 
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
				if(i != j && adjMatrix[i][j] == 0) { // 인접해있지 않은 경우 (연결이 안돼있는경우)
					adjMatrix[i][j] = INF;//비용이 정수값이라 총 비용이 0이 되는 경우가 있기 때문에 구분해야함
				}
			}
		}
		print();
		
		for (int via = 0; via < N; via++) {//경유지
			for (int from = 0; from < N; from++) {//출발지
				if(via == from) continue;
				for (int to = 0; to < N; to++) {//도착지
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
