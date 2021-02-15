package com.ssafy.heap;
/**
 * interface : Comparable, Comparator
 * 객체의 정렬과 관련된 인터페이스
 * Comparable : 클래스 내부에 객체의 정렬기준을 만들어 놓을때 사용됨. 이 인터페이스를 구현한 객체에게 주는 한 가지 기본 정렬 규칙.
 * Comparator : 클래스 외부에 객체의 정렬기준을 만들어 놓을때 사용됨. Comparable이 구현된 클래스들의 기본 정렬 규칙과는 다르게 주어진 특정 기준을 가지고 정렬 순서를 지정하고 싶을때.
 * */
public class Writer implements Comparable<Writer>{
	int num;
	String name;
	int age;
	String title;
	
	public Writer(int num, String name, int age, String title) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Writer [num=" + num + ", name=" + name + ", age=" + age + ", title=" + title + "]";
	}

	@Override
	public int compareTo(Writer other) {
		//오름차순 정렬
		//int result = this.num - other.num; //원래 natural order는 오름차순 정렬. 양수 : 기준이 더 크다. 서로 바꿔줌.
		//내림차순 정렬
		int result =  other.num - this.num;
		return result;
	}
	
	
}
