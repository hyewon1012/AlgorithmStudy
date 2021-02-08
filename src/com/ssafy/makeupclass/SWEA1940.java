package com.ssafy.makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// �ڹٿ��� switch ���� ���������� �ؽ��� �����Ǿ��ֱ� ������ switch�� ������ ������
public class SWEA1940 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) { // for�� 1�������� 1�ʰ� ����
			int N = Integer.parseInt(br.readLine()); // ������ ������ 0 ����ӵ� ����, 1 ����, 2 ����
			int v = 0; // �ڵ����� ���� �ӵ�
			int m = 0; // �ڵ����� �� �̵� �Ÿ� ����
			for (int i = 0; i < N; i++) {
				String com = br.readLine();
				switch (com.charAt(0)) {
//				case '0': // ����ӵ�����
//					break;
				case '1' : //����
					v += com.charAt(2)-'0';
					break;
				case '2' : // ����
					v -= com.charAt(2)-'0';
					if(v < 0) v = 0; // ���� �ӵ����� ������ �ӵ��� �� Ŭ ��� �ӵ�� 0
					break;
				}
				m += v;
			}
			sb.append("#").append(t).append(" ").append(m).append("\n");
		} // end of for testCase
		System.out.print(sb);
	}//end of main
}//ed of class
