package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon_12927_�������ġ {
/**
 * ��� ������ ���� ����ġ ��� �������ϴ���
 * i������ġ i�� ��� ����ġ ��� ��
 * 101010101 -> 010101010 -> 
 * */
	static char[] switchs;
	static int SIZE = 0;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switchs = new char[1001];
		
		String s[] = br.readLine().split("");
		for (int i = 1; i <= s.length; i++) {
			switchs[i] = s[i-1].charAt(0);
		}
		
		//Set<Integer> set = new HashSet<Integer>();
		List<Integer> multiple = new ArrayList<Integer>();
		List<Integer> copy = new ArrayList<Integer>();
		
		boolean allN = true;
		boolean allY = true;
		for (int i = 1; i <= s.length; i++) {
			if(switchs[i] != 0) {
				SIZE++;
				if(switchs[i] == 'Y') {
					multiple.add(i);
					copy.add(i);
					allN = false;
				}
				if(switchs[i] == 'N') {
					allY = false;
				}
			}
			
		}

		
		for (int i = 0; i < multiple.size(); i++) {
			int copySize = copy.size();
			for (int j = 0; j < copySize; j++) {
				if(multiple.get(i) % copy.get(j) == 0) {
					copy.remove(j);
					copySize--;
				}
			}
			
			
		}
		
		for (Integer integer : copy) {
			System.out.println(integer);
		}
		
//		while(!q.isEmpty()) {
//			int first = q.poll();
//			if(first == 1) {
//				//��Ʈ����
//				change(1, SIZE);
//				q.remove(first);
//			}
//			//��� �� �����
//			int removed = q.poll();
//			for (int i = 1; i <= SIZE; i++) {
//				if(removed % switchs[i] == 0) {
//					q.remove(i);
//				}
//			}
//			for (Integer i : q) {
//				System.out.println(i);
//			}
//		}
		
		//���Y�϶�
		if(allY) {
			System.out.println(1);
		}
		//�� ����������
		if(allN) {
			System.out.println(0);
		}
	}
	
	public static void change(int start, int end) {
		
		for (int i = start; i <= end; i++) {
			if(switchs[i] == 'Y') {
				switchs[i] = 'N';
			}else {
				switchs[i] = 'Y';
			}
		}
		

	}

}
