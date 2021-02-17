package com.ssafy.divideAndconquer;

import java.util.Scanner;

public class SquareNumberTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long x = sc.nextInt();
		long y = sc.nextInt();
		
		System.out.println(exp(x,y));
		
	}
	//x�� y�ŵ����� ������������ ���ϱ�
	private static long exp(long x, long y) {
		if(y==1) return x;
		
		long r = exp(x, y/2);
		long result = r*r;
		if(y%2==1) result *= x;
		return result;
	}

}
