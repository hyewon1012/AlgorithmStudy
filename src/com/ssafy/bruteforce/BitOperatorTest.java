package com.ssafy.bruteforce;

public class BitOperatorTest {

	public static void main(String[] args) {
		// 16���� ���ڸ��� 2���� ���ڸ�
		int k = 0xa5; // 1010 0101
		//k��Ʈ���� ������ �����ʿ��� 1��ŭ ������ ��Ʈ�� ���� Ȯ��
		//1 - on : ����� , �湮����
		//0 - off - �̻���� , �����湮�����ʾ���
		System.out.println((k & 1<<2) + "//" + Integer.toBinaryString(k & 1<<2));
		//32��Ʈ -> 32 �÷��׷� ����ϸ� 32�� ǥ�� ����

		//k��Ʈ���� �����ʿ��� 1��ŭ ������ �ڸ� 1��Ʈ�� �����
		System.out.println(k | 1<<1);
	}

}
