package com.ssafy.heap;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<Student>();
		pq.offer(new Student(4,20));
		pq.offer(new Student(3,50));
		pq.offer(new Student(1,60));
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());

	}

}
