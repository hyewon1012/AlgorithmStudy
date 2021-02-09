package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233_��Ģ������ȿ���˻� {
/**
 * ��� ���� - N
 * ���ٸ��� ����ȣ, �����ڽ� ����ȣ, �������ڽ� ����ȣ
 * @throws IOException 
 * @throws NumberFormatException 
 */
	static String[][] binaryTree; // tree[����ȣ][0] �����ڽ� tree[����ȣ][1] �������ڽ�
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
			
			//leaf node�� ���
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
