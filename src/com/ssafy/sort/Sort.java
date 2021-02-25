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
		//�迭������ �ִ밪 ǥ�� ������ ũ���� ī���� �迭 ����
		int[] count = new int[max+1];
		//�迭���� ī����
		for (int i = 0; i < SIZE; i++) {
			count[list[i]]++;
		}
		//ī���� ���� : ������
		for (int i = min+1; i <= max; i++) {
			count[i] = count[i-1] + count[i];
		}
		//�迭���� �ϳ��� �鿩�ٺ��� ����迭�� �� ���Ұ��� �ش��ϴ� ��ġ�� ä��
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
		// �� �������� �����Ͽ� ���� ���Ľ�Ŵ.
		int mid = (start+end) / 2;
		mergeSort(list, start, mid); // ��������
		mergeSort(list, mid+1, end); // ����������
		
		// ���ĵ� �������� ����
		merge(list, start, mid, end);
	}

	private static void merge(int[] list, int start, int mid, int end) {
		int left = start; //�������� �ε��� ������ġ
		int right = mid+1; //���������� �ε��� ������ġ
		int size = end-start+1;
		int[] newArr = new int[size];
		
		int i = 0; //����迭�ε���
		do {
			if(list[left] < list[right]) {
				newArr[i++] = list[left++];
			}else {
				newArr[i++] = list[right++];
			}
		}while(left <= mid && right <= end);
		
		//������ ������ �� �Һ�� ���
		while(left <= mid) {
			newArr[i++] = list[left++];
		}
		//���� ������ �� �Һ�� ���
		while(right <= end) {
			newArr[i++] = list[right++];
		}
		System.arraycopy(newArr, 0, list, start, newArr.length);
	}

}
