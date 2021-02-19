package com.ssafy.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//�� ��ǥ ����
class Customer{
	int y;
	int x;
	
	public Customer(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}
public class SWEA_1247_������� {
/**
 * ȸ�� -> �� -> �� : ��� �湮�ϰ� ���� ª�� �Ÿ� ã��
 * �׸��� + DFS�� Ǯ��. �湮 ����(track) �������ʴ´�.
 * �� ���� ���� -> �Ÿ� ����
 **/

	static boolean[] isSelected;
	static int ans;
	static int oy,ox,hy,hx;
	static ArrayList<Customer> customer;
	static int[] result;
	static int[] numbers;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			isSelected = new boolean[N];
			result = new int[N];
			numbers = new int[N];
			for (int i = 0; i < N; i++) {
				numbers[i] = i;
			}
			//ȸ�� �� ����ǥ
			oy=0; ox=0;
			hy=0; hx=0;
			
			customer = new ArrayList<Customer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			oy = Integer.parseInt(st.nextToken());
			ox = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());
			hx = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				int cy = Integer.parseInt(st.nextToken());
				int cx = Integer.parseInt(st.nextToken());
				customer.add(new Customer(cy, cx));
			}
			//N�� �� ���� ����
			ans = Integer.MAX_VALUE;
			solve(0);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}// end of test case
		System.out.print(sb);

	}// end of main

	private static void solve(int cnt) {
		if(cnt == N) {
			
			//����
			int dist=0;
			//ȸ�� - ù ��
			dist += Math.abs(oy-customer.get(result[0]).y) + Math.abs(ox-customer.get(result[0]).x);
			//���鰣 �Ÿ� �� ��� 0 1 2 3 4
			for (int i = 0; i < N-1; i++) {
				int nowIdx = result[i];
				int nextIdx = result[i+1];
				dist += Math.abs(customer.get(nextIdx).y-customer.get(nowIdx).y) + Math.abs(customer.get(nextIdx).x-customer.get(nowIdx).x);
			}
			//�������� - �� �Ÿ� ���
			dist += Math.abs(hy-customer.get(result[N-1]).y) + Math.abs(hx-customer.get(result[N-1]).x);
			ans = Math.min(ans,dist);
			return;
		}
		else {
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) continue;
				else {
					isSelected[i] = true;
					result[cnt] = numbers[i];
					solve(cnt+1);
					isSelected[i] = false;
				}
				
			}
				
		}
		
	}
	

}
