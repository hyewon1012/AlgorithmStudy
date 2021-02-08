package com.ssafy.makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 자바에서 switch 문은 내부적으로 해쉬로 구현되어있기 때문에 switch가 월등히 빠르다
public class SWEA1940 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) { // for문 1차수마다 1초가 진행
			int N = Integer.parseInt(br.readLine()); // 한줄의 데이터 0 현재속도 유지, 1 가속, 2 감속
			int v = 0; // 자동차의 현재 속도
			int m = 0; // 자동차의 총 이동 거리 누적
			for (int i = 0; i < N; i++) {
				String com = br.readLine();
				switch (com.charAt(0)) {
//				case '0': // 현재속도유지
//					break;
				case '1' : //가속
					v += com.charAt(2)-'0';
					break;
				case '2' : // 감속
					v -= com.charAt(2)-'0';
					if(v < 0) v = 0; // 현재 속도보다 감속할 속도가 더 클 경우 속드는 0
					break;
				}
				m += v;
			}
			sb.append("#").append(t).append(" ").append(m).append("\n");
		} // end of for testCase
		System.out.print(sb);
	}//end of main
}//ed of class
