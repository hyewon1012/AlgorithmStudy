package com.ssafy.sort;

public class Sort {
	
	public static void countingSort(int[] list) {
		final int SIZE = list.length;
		int[] result = new int[SIZE];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < SIZE; i++) {
			if(list[i] < min) {
				min = list[i];
			}
			if(list[i] > max) {
				max  = list[i];
			}
		}
		//배열원소의 최대값 표현 가능한 크기의 카운팅 배열 생성
		int[] count = new int[max+1];
		//배열원소 카운팅
		for (int i = 0; i < SIZE; i++) {
			count[list[i]]++;
		}
		//카운팅 변형 : 누적합
		for (int i = min+1; i <= max; i++) {
			count[i] = count[i-1] + count[i];
		}
		//배열원소 하나씩 들여다보며 결과배열의 각 원소값에 해당하는 위치에 채움
		for (int i = SIZE-1; i >= 0; i--) {
			result[--count[list[i]]] = list[i];
		}
		System.arraycopy(result, 0, list, 0, SIZE);
	}
	
	public static void mergeSort(int[] list) {
		mergeSort(list, 0, list.length-1);
	}
	
	private static void mergeSort(int[] list, int start, int end) {
		if(start == end) return;
		// 두 집합으로 분할하여 각각 정렬시킴.
		int mid = (start+end) / 2;
		mergeSort(list, start, mid); // 왼쪽집합
		mergeSort(list, mid+1, end); // 오른쪽집합
		
		// 정렬된 두집합을 병합
		merge(list, start, mid, end);
	}

	private static void merge(int[] list, int start, int mid, int end) {
		int left = start; //왼쪽집합 인덱스 시작위치
		int right = mid+1; //오른쪽집합 인덱스 시작위치
		int size = end-start+1;
		int[] newArr = new int[size];
		
		int i = 0; //결과배열인덱스
		do {
			if(list[left] < list[right]) {
				newArr[i++] = list[left++];
			}else {
				newArr[i++] = list[right++];
			}
		}while(left <= mid && right <= end);
		
		//오른쪽 집합이 다 소비된 경우
		while(left <= mid) {
			newArr[i++] = list[left++];
		}
		//왼쪽 집합이 다 소비된 경우
		while(right <= end) {
			newArr[i++] = list[right++];
		}
		System.arraycopy(newArr, 0, list, start, newArr.length);
	}

}
