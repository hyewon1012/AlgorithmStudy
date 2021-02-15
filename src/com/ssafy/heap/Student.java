package com.ssafy.heap;

public class Student implements Comparable<Student> {
	public int no,score;

	@Override
	public String toString() {
		return "Student [no=" + no + ", score=" + score + "]";
	}

	public Student(int no, int score) {
		super();
		this.no = no;
		this.score = score;
	}

	@Override
	public int compareTo(Student o) {
		return this.no - o.no;
	};
	
}
