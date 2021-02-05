package com.ssafy.io;

import java.util.Scanner;

public class IO2_ScannerTest {

	public static void main(String[] args) {
		String src = "안 \n녕\n Hello";
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(src);
		System.out.print("읽은 문자열 : " +sc.next());
		System.out.print(",읽은 문자열 : " +sc.next());
		System.out.print("\n===========================");
		
		String s2 = "안 녕\n";
		Scanner sc2 = new Scanner(s2);
		System.out.print("읽은 문자열 : "+sc2.nextLine());
		System.out.print("\n===========================");

		String s3 = "안 \n    녕\n";
		Scanner sc3 = new Scanner(s3);
		System.out.print("읽은 문자열 : "+sc3.nextLine());
		System.out.print(",읽은 문자열 : "+sc3.nextLine());
		System.out.print("\n===========================");
	}

}
