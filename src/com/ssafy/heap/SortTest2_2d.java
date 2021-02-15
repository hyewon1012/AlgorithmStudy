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
		//���ҽ����� �� �Ǵ��� ������ ��� ����. ����̸� �����.
		//Arrays.sort(students)
		Arrays.sort(students, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				//�й��� ������ ���� ���� ��������
				//int diff =  o1[0]-o2[0];
				//����� ������ ����������
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
