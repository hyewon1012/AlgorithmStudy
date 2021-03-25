package com.ssafy.dp;

import java.util.Arrays;
import java.util.Scanner;

public class LISTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr= new int[N]; // ���ҵ� ����
		int[] LIS = new int[N]; // �� ��ġ -> LIS ���̸� �����ϴ� ������ �ּҰ�
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);
			temp = Math.abs(temp)-1; // �ߺ����� �����Ƿ� Ž���� �����ϰ� �������� ����
			LIS[temp] = arr[i]; // �ǵڿ� �߰��ǰų� ������ġ�� ����� ��Ȳ
			if(temp == size) ++size;
		}
		System.out.println(size);
	}

}
