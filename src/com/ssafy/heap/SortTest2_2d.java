package com.ssafy.heap;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest2_2d {
	public static void main(String[] args) {
		int[][] students = {
				{1,10},
				{3,50},
				{4,10},
				{1,100}
		};
		print(students);
		//원소스스로 비교 판단이 가능한 기능 없음. 도우미를 줘야함.
		//Arrays.sort(students)
		Arrays.sort(students, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				//학번이 같으면 점수 기준 내림차순
				//int diff =  o1[0]-o2[0];
				//양수와 음수가 섞여있을때
				int diff = Integer.compare(o1[0], o2[0]);
				return diff != 0 ? diff : o2[1]-o1[1];
			}
		});
		
		
		print(students);
		
	}
	
	private static void print(int[][] arr) {
		for(int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
	}
}
