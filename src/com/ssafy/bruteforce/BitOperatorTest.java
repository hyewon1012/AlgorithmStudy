package com.ssafy.bruteforce;

public class BitOperatorTest {

	public static void main(String[] args) {
		// 16진수 한자리가 2진수 네자리
		int k = 0xa5; // 1010 0101
		//k비트열의 상태중 오른쪽에서 1만큼 떨어진 비트의 상태 확인
		//1 - on : 사용중 , 방문했음
		//0 - off - 미사용중 , 아직방문하지않았음
		System.out.println((k & 1<<2) + "//" + Integer.toBinaryString(k & 1<<2));
		//32비트 -> 32 플래그로 사용하면 32개 표현 가능

		//k비트열의 오른쪽에서 1만큼 떨어진 자리 1비트로 만들기
		System.out.println(k | 1<<1);
	}

}
