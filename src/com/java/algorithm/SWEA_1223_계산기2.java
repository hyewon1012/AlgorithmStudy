package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SWEA_1223_����2 {
	static Stack<Character> midStack;
	static Stack<Integer> postfixStack;
	//�Է°� �켱������ �� ������ true
	//���ų� ������ false
	public static boolean check(char input, char top) {
		if(input == '*' && top != '*') return true;
		else if(input == '+' && top == '*') return false;
		else return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			
			char[] mid = new char[N];
			char[] result = new char[N];
			midStack = new Stack<>();
			mid = br.readLine().toCharArray();
			int idx = 0;
			//����ǥ��� ����ǥ������� ��ȯ
			for (int i = 0; i < N; i++) {
				if(mid[i] != '+' && mid[i] != '*') { //�ǿ������϶�
					result[idx++] = mid[i];
					
				}else {
					if(midStack.empty()) {
						midStack.push(mid[i]);
					}else {
						if(!check(mid[i], midStack.peek())) {
							result[idx++] = midStack.pop();
							midStack.push(mid[i]);
						}else {
							midStack.push(mid[i]);
						}	
					}
				}
			}
			while(!midStack.empty()) {
				result[idx++] = midStack.pop();
			}
			
			
			//����ǥ��� ���
			postfixStack = new Stack<>();
			for (int i = 0; i < result.length; i++) {
				if(result[i] != '*' && result[i] != '+') {
					postfixStack.push(result[i]-'0');
				}else {
					int r = postfixStack.pop();
					int l = postfixStack.pop();
					if(result[i] == '*') {
						postfixStack.push(r*l);
					}else {
						postfixStack.push(r+l);
					}
				}
			}
			sb.append("#").append(t).append(" ").append(postfixStack.pop()).append("\n");
			
		}
		System.out.print(sb);
	}

}
