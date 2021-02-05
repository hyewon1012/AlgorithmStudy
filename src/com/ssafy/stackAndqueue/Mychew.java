package com.ssafy.stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Mychew {

	public static void main(String[] args) {
		int N = 20;
		int person = 1;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {person,1});
		
		int[] p;
		int availableCnt = 0;
		while(N > 0) {
			p = q.poll();
			availableCnt = (N >= p[1]) ? p[1] : N;
			N -= availableCnt;
			if(N==0) {
				System.out.println("마지막 마이쮸를 가져간 사람 : " + p[0] + "," + availableCnt +"개");
			}else {
				System.out.println(p[0] +"번 사람이 마이쮸를 가져갑니다. 남은개수: "+N+"개");
				p[1]++;
				q.add(p);
				q.add(new int[] {++person, 1});
			}
			
		}
		
	}

}
