package com.ssafy.heap;

import java.util.Comparator;

//Writer Ŭ������ name �������� �� �� ���Ľ��� �ִ� Ŭ����
public class WriterNameComparator implements Comparator<Writer>{

	@Override
	public int compare(Writer o1, Writer o2) {
		int result = o1.name.compareTo(o2.name); // ���������� string�� �����ش�
		if(result == 0) { // �Ȱ����� �ι�° ���� ������ �ش�
			return o1.title.compareTo(o2.title);
			//return o1.age - o2.age;
		}
		return 0;
	}

}
