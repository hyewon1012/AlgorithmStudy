package com.ssafy.off;

public class RecursiveTest {
	static void recur(int start, int end, int step) {
		//1. ������Ʈ
		if(start > end) {
			System.out.println();
			return;
		}
		//2. �ݺ���Ʈ
		System.out.print(start + " ");
		recur(start+step, end, step);
		
	}
	private static int total = 0;
	static void sum(int start, int end) {
		//1. ������Ʈ
		if (start > end) {
			System.out.println("��:" + total);
		}
		else {
			// �ݺ���Ʈ - ����, ���ȣ��
			total += start;
			sum(start+1, end);
		}

	}
	
	public static void main(String[] args) {
		//1. recur() : start, end , step �ݺ���ó�� ���ٿ� ������ش�.
		recur(1,10,2);
		//2. sum() : start,end. start~end ������ ���� ���ϴ� �Լ�
		sum(1,10);
	}

}
