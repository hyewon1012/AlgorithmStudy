package com.ssafy.off;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225 {
	static int[] password;
	
	private static void solve(int[] password) {
		Queue<Integer> q = new LinkedList<>();
		
		for (Integer item : password) {
			q.add(item);
		}
		
		while(true) {
			//�ѻ���Ŭ 1~5����
			for (int i = 1; i <= 5; i++) {
				int head = q.poll();
				if(head-i <= 0) {
					q.add(0);
					for (Integer ele : q) {
						System.out.print(ele+" ");
					}
					return;
				}else {
					q.add(head-i);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		//8���� ���ڸ� 1~5���� ���ҽ�Ű�°� �� ����Ŭ
		//0�����۾����� 0���� �����ϰ� ���� -> �̶� 8�ڸ� ��ȣ
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 10; t++) {
			int tc = sc.nextInt();
			password = new int[8];
			for (int i = 0; i < 8; i++) {
				password[i] = sc.nextInt();
			}
			
			System.out.print("#" + tc+" ");
			solve(password);
			System.out.println();
			
		}
		
		
	}

}
