package com.ssafy.io;

import java.util.Scanner;

public class IO1_ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����,�Ǽ�,���ڿ��� ���ʷ� �Է��ϼ���.");
		
		System.out.println("���� ���� : " +sc.nextInt());
		System.out.println("���� �Ǽ� : " +sc.nextDouble());
		//System.out.println("���� ���ڿ� : " +sc.next());
		System.out.println("���� ���ڿ� : " +sc.nextLine());

	}

}
