package com.ssafy.stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAPITest {
	
	public static void main(String[] args) {
		//�̷� �������� ����ϱ⺸�� �����ؼ� �츮�� ����Ϸ��� �޼ҵ带 ��Ȯ�ϰ� ����
		//LinkedList<String> queue = new LinkedList<String>();
		Queue<String> q = new LinkedList<String>(); 
		q.add("������");
		q.add("������");
		q.add("��ȿ��");
		q.add("������");
		q.add("�ֿ켱");
		
		System.out.println(q.isEmpty() + "//" + q.size());
		System.out.println(q.peek());
		System.out.println(q.isEmpty() + "//" + q.size());
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
	}
}
