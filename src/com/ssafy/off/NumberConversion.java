package com.ssafy.off;

public class NumberConversion {
	public static void main(String[] args) {
		int n0 = Integer.parseInt("11", 10); //10���� -> 10����
		int n1 = Integer.parseInt("11", 2); //2���� -> 10����
		int n2 = Integer.parseInt("11", 8); //8���� -> 10����
		
		System.out.printf("%d, %d\n",n1, n2);
		
		String s1 = Integer.toBinaryString(15); // int -> 2����
		String s2 = Integer.toOctalString(8); // int -> 8����
		System.out.printf("%s, %s\n",s1, s2);
	}
}
