package com.ssafy.makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1493_수의새로운연산 {
/**
 * #(x,y) = (x,y)에 할당된수 -> 1 2 4 7 11 #(2,3) = 
 * &(p) = 숫자p가 할당된 좌표값 (x,y)
 * p★q = #(&(p)+&(q))
 * */
	
	static int[] s = new int[300];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		s[1] = 1; // 초기값
		for (int i = 2; i < s.length; i++) { // 행의 시작값
			s[i] = s[i-1]+i-1;
		}
		

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			String[] coordi = br.readLine().split(" ");
			int p = Integer.parseInt(coordi[0]);
			int q = Integer.parseInt(coordi[1]);
			int r,c;
			//p값의 r,c
			r = getR(p);
			c = p - s[r] + 1;
			r = r - (p - s[r]);
			int rSum = r;
			int cSum = c;
			
			//q값의 r,c
			r = getR(q);
			c = q - s[r] + 1;
			r = r - (q - s[r]);
			rSum += r;
			cSum += c;
			
			int val = s[rSum + cSum -1] + cSum -1;
			
			sb.append("#").append(t).append(" ").append(val).append("\n");
		}// end of test case
		System.out.print(sb);
		

	} // end of main
	
	//val 값이 1열의 몇번째 행에서 시작하는지 찾는다.
	/** val 숫자에 해당하는 좌표(r,c)를 구하기 위해 s 배열에 몇번째 index 라인인지 리턴 */
	private static int getR(int val) {
		int result = 0;
		for (int i = 1; i < s.length; i++) {
			if(s[i] > val) {
				result = i-1;
				break;
			}
		}
		return result;
	}
	
	

}
