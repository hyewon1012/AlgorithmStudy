package com.ssafy.makeupclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1940_����RCī {
	
	//command 0 : ����, 1 : ����, 2 : ����
	//���Ӱ��� ���Ӱ����� ũ�� �ӵ��� = 0
	static int v; //���� �ӵ���
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			int total = 0; // ���� �Ÿ�
			int N = Integer.parseInt(br.readLine());
			//command
			v = 0;
			for (int c = 0; c < N; c++) {
				String[] data = br.readLine().split(" ");
				int command = Integer.parseInt(data[0]);
				if(command == 0) {
					total += v;
				}else if(command == 1) {
					v += Integer.parseInt(data[1]);
					total += v;
				}else {
					if(v < Integer.parseInt(data[1])) {
						v = 0;
						total += v;
					}else {
						v -= Integer.parseInt(data[1]);
						total += v;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(total).append("\n");
		}//�׽�Ʈ���̽� ��
		
		System.out.print(sb);
	}
}
