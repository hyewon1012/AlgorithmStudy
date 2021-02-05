package com.ssafy.off;

import java.util.Scanner;

public class Baekjoon_17478 {
	StringBuilder sb = new StringBuilder();
	static String question = "\"����Լ��� ������?\"\n";
	static String teaching1 = "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n";
	static String teaching2 = "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n";
	static String teaching3 = "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n";
	static String answer = "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n";
	static String ending = "��� �亯�Ͽ���.\n";
	
	static void makeSpace(int depth) {
        StringBuilder prefix = new StringBuilder("");
        for (int i=1; i <= depth*4; i++){
            prefix.append("_");
        }
        System.out.print(prefix);
	}
	
	static void recursive(int n, int end, int depth) {
		makeSpace(depth);
		System.out.print(question);
		//1. base case
		if (n == end) {
			makeSpace(depth);
			System.out.print(answer);
		}
		else {
			makeSpace(depth);
			System.out.print(teaching1);
			makeSpace(depth);
			System.out.print(teaching2);
			makeSpace(depth);
			System.out.print(teaching3);
			recursive(n+1, end, depth+1);
		}
		makeSpace(depth);
		System.out.print(ending);

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		recursive(0, n, 0);
	}

}
