package com.ssafy.heap;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {
	static class StudentComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			return o2.no - o1.no;
		}
		
	}
	
	public static void main(String[] args) {
		Student[] students = {
				new Student(1, 10),
				new Student(3, 50),
				new Student(2, 80),
				new Student(4, 10)
		};
		System.out.println(Arrays.toString(students));
		Arrays.sort(students);//comparable 인터페이스를 구현하지 않았기때문에 런타임에러
		System.out.println(Arrays.toString(students));
		//이미 배포했음. 클래스 사용만 가능하고 변경할수없는 상태
		Arrays.sort(students, new StudentComparator());//원래 객체가 정렬할수잇더라도 comparator가 우선순위를 갖게된다.
		System.out.println(Arrays.toString(students));
		
		//한번 사용하니깐 익명클래스로 만들어보자
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.score - o2.score;
			}
			
		});
		System.out.println(Arrays.toString(students));
		
		//람다식으로도 만들어보자
		Arrays.sort(students, (o1, o2) -> o2.score - o1.score);//내림차순
		System.out.println(Arrays.toString(students));

	}

}
