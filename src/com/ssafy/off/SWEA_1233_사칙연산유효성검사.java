package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233_사칙연산유효성검사 {
/**
 * 노드 개수 - N
 * 각줄마다 노드번호, 왼쪽자식 노드번호, 오른쪽자식 노드번호
 * @throws IOException 
 * @throws NumberFormatException 
 */
	static String[][] binaryTree; // tree[노드번호][0] 왼쪽자식 tree[노드번호][1] 오른쪽자식
	static String[] tree;
	static int N;
	static boolean answer;
	
//	private static boolean dfs(int idx) {
//		if(idx > N) return false;
//		answer = dfs(idx*2);
//		if(tree[idx].equals("*") || tree[idx].equals("/") || tree[idx].equals("-")|| tree[idx].equals("+")) {
//			return false;
//		}
//		answer = dfs(idx*2+1);
//		return answer;
//	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		final int TC = 10;
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			int ans = 1;
			String[] s = br.readLine().split(" ");
			
			//leaf node일 경우
			if(s.length == 2) {
				if(s[1].equals("*") || s[1].equals("/") || s[1].equals("+") || s[1].equals("-")) {
					ans = 0;
					break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
			
		}// end of test case
		System.out.print(sb);
	}// end of main

}// end of class
