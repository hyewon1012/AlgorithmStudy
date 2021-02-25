package com.ssafy.sort;

import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {
		int[] list = {69,10,2,2,16};
		System.out.println(Arrays.toString(list));
//		Sort.countingSort(list);
//		System.out.println(Arrays.toString(list));
		Sort.mergeSort(list);
		System.out.println(Arrays.toString(list));

	}

}
