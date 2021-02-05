package com.ssafy.recursive;

public class recursiveTest {
	//반복문
	private static int factorial(int n) {
		int result = 1;
		for (int i = n; i > 0; --i) {
			result *= i; //단위반복
		}
		return result;
	}
	private static int res=1;
	private static void facitorial2(int n) {
		if(n==0) return;
		res*=n;
		facitorial2(n-1);
	}
	//재귀
	private static int facitorial3(int n) {
		if (n==1) return 1;
		return n * facitorial3(n-1);
	}

	
	public static void main(String[] args) {
		int n=5;
		
		System.out.println(factorial(n));
		facitorial2(n);
		System.out.println(res);
		System.out.println(facitorial3(n));
	}

}
