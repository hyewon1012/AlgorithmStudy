package com.ssafy.stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAPITest {
	
	public static void main(String[] args) {
		//이런 다형성을 사용하기보단 제한해서 우리가 사용하려는 메소드를 정확하게 하자
		//LinkedList<String> queue = new LinkedList<String>();
		Queue<String> q = new LinkedList<String>(); 
		q.add("김태희");
		q.add("윤이진");
		q.add("노효진");
		q.add("변성문");
		q.add("최우선");
		
		System.out.println(q.isEmpty() + "//" + q.size());
		System.out.println(q.peek());
		System.out.println(q.isEmpty() + "//" + q.size());
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
	}
}
