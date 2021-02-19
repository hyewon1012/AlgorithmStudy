package com.ssafy.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WriterTest {

	public static void main(String[] args) {
		ArrayList<Writer> list = new ArrayList<Writer>();
		list.add(new Writer(1, "Kim", 27, "���������"));
		list.add(new Writer(3, "Lee", 24, "R�� �����ϴ� ������ �м�"));
		list.add(new Writer(7, "Kim", 22, "�����ڹ�"));
		list.add(new Writer(2, "Park", 22, "����Ƽ���ڹ�"));
		list.add(new Writer(6, "Jung", 22, "�ΰ�ä"));
		
		//�⺻�� �����͸� ���� ����
		//Arrays.sort();
		Collections.sort(list);//Comparable Ÿ���� ��ü���� ��.
//		for (Writer w : list) {
//			System.out.println(w);
//		}
		//Collections.sort(list, (o1,o2) -> o1.name - o2.name);
		//1. Ŭ���� ���� ���� ���� �߰�
		Collections.sort(list,  new WriterNameComparator());

		//2. �͸� Ŭ������ ���� ���� �߰� (���̱���)
		//Comparator�� impl�ϴ� ���� ��ü
		Collections.sort(list, new Comparator<Writer>() {
			@Override
			public int compare(Writer o1, Writer o2) {
				return o1.age - o2.age;
			}
		});
		
		//3. ���ٷ� ���� ���� ���� �߰�
		Collections.sort(list, (o1,o2) -> {
			int age = o1.age - o2.age;
			if(age==0) {
				return o1.title.compareTo(o2.title);
			}
			return age;
		});
		//2021.02.19 - ���ٷ� ���� ���� �����
		//Collections.sort(list, (o1,o2) -> o1.age - o2.age);
		//Collections.sort(list, (o1,o2) -> o1.title.compareTo(o2.title));
		
		for (Writer w : list) {
			System.out.println(w);
		}
	}

}
