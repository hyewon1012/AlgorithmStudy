package com.ssafy.heap;

import java.util.Comparator;

//Writer 클래스의 name 기준으로 비교 후 정렬시켜 주는 클래스
public class WriterNameComparator implements Comparator<Writer>{

	@Override
	public int compare(Writer o1, Writer o2) {
		int result = o1.name.compareTo(o2.name); // 내부적으로 string을 비교해준다
		if(result == 0) { // 똑같으면 두번째 정렬 조건을 준다
			return o1.title.compareTo(o2.title);
			//return o1.age - o2.age;
		}
		return 0;
	}

}
