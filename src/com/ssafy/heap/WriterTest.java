package com.ssafy.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WriterTest {

	public static void main(String[] args) {
		ArrayList<Writer> list = new ArrayList<Writer>();
		list.add(new Writer(1, "Kim", 27, "오만과편견"));
		list.add(new Writer(3, "Lee", 24, "R로 시작하는 데이터 분석"));
		list.add(new Writer(7, "Kim", 22, "두잇자바"));
		list.add(new Writer(2, "Park", 22, "이펙티브자바"));
		list.add(new Writer(6, "Jung", 22, "민경채"));
		
		//기본형 데이터만 정렬 가능
		//Arrays.sort();
		Collections.sort(list);//Comparable 타입의 객체여야 함.
//		for (Writer w : list) {
//			System.out.println(w);
//		}
		//Collections.sort(list, (o1,o2) -> o1.name - o2.name);
		//1. 클래스 만들어서 정렬 기준 추가
		Collections.sort(list,  new WriterNameComparator());

		//2. 익명 클래스로 정렬 기준 추가 (나이기준)
		//Comparator를 impl하는 무명 객체
		Collections.sort(list, new Comparator<Writer>() {
			@Override
			public int compare(Writer o1, Writer o2) {
				return o1.age - o2.age;
			}
		});
		
		//3. 람다로 나이 정렬 기준 추가
		Collections.sort(list, (o1,o2) -> {
			int age = o1.age - o2.age;
			if(age==0) {
				return o1.title.compareTo(o2.title);
			}
			return age;
		});
		//2021.02.19 - 람다로 정렬 기준 만들기
		//Collections.sort(list, (o1,o2) -> o1.age - o2.age);
		//Collections.sort(list, (o1,o2) -> o1.title.compareTo(o2.title));
		
		for (Writer w : list) {
			System.out.println(w);
		}
	}

}
