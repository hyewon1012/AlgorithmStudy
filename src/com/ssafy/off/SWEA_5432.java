package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//Ž�� ��� Greedy �˰���
//�����̴� ���̵� �� �ʿ��ϴ� ������ ���� �غ�����
/**
 * sum : �߷��� ������ �Ѱ��� ����
 * cnt : �����ִ� �踷��� ����
 * 
 * () ������	: sum += cnt
 * (		: cnt++
 * )		: sum++, cnt--
 */
public class SWEA_5432 {
	//cnt�� ���� ������������ -1 +1 �̷��� ��ȭ�Ѵ� <- ������ȣ�� cnt-1 sum+1
	//sum �� ���� ������
	//�������� ������ sum+=cnt
	static char[] arr;
	static Stack<Character> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			String s = br.readLine(); // ()()()() �̷� ���ڿ�
			s = s.replace("()", "v"); // �ƴ� ������ õ��...
			//replace�ص� string�� ���� �迭�� �ٲ����ʴ´�
			
			int sum = 0; // �߷��� ������ �Ѱ��� ����
			int cnt = 0; // �����ִ� �踷��� ����
			//(((v)))(v)v () => v
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == 'v') { // v ������
					sum += cnt; // �踷��⸸ŭ ����
				}else if(s.charAt(i) == '(') { // ���۰�ȣ
					cnt++; // �踷��� �߰�
				}else { // �ݴ� ��ȣ
					sum++; //�踷��� 1�� ������, ���� �߰�
					cnt--; // �踷��� ���� 1�� �پ��
				}
			}
			sb.append("#").append(testCase).append(" ").append(sum).append("\n");			
		}
		System.out.print(sb);
	}

}
