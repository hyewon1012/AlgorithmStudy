package com.ssafy.io;

import java.util.Scanner;

public class IO2_ScannerTest {

	public static void main(String[] args) {
		String src = "�� \n��\n Hello";
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(src);
		System.out.print("���� ���ڿ� : " +sc.next());
		System.out.print(",���� ���ڿ� : " +sc.next());
		System.out.print("\n===========================");
		
		String s2 = "�� ��\n";
		Scanner sc2 = new Scanner(s2);
		System.out.print("���� ���ڿ� : "+sc2.nextLine());
		System.out.print("\n===========================");

		String s3 = "�� \n    ��\n";
		Scanner sc3 = new Scanner(s3);
		System.out.print("���� ���ڿ� : "+sc3.nextLine());
		System.out.print(",���� ���ڿ� : "+sc3.nextLine());
		System.out.print("\n===========================");
	}

}
