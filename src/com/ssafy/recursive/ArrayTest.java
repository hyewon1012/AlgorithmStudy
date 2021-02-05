package com.ssafy.recursive;

public class ArrayTest {
	
	static int arr[] = {10,20,30,40,50};
	static int arr2[][] = {{11,12,13},{20,30,40}};
	
	//현재 배열의 원소 출력
	private static void printArray1(int idx) {
		//현재원소출력하고 나머지 출력
		if(idx == arr.length) {
			System.out.println();
			return;
		}
		System.out.print(arr[idx]+"\t");
		printArray1(idx+1);
	}
	
	//현재 배열의 원소 출력
	private static void printRowArray(int row) {
		//현재 행 출력하고 나머지 출력
		//매개체는 행
		if(row == arr2.length) {
			System.out.println();
			return;
		}
		for (int col = 0; col < arr2[row].length; col++) {
			System.out.print(arr2[row][col]+" ");
		}
		System.out.println();
		printRowArray(row+1);
		
	}
	
	//현재 배열의 원소 출력
	private static void printElementArray(int row, int col) {
		//현재 원소 출력하고 나머지 출력
		//매개체는 row, col
		if(row == arr2.length && col == arr2[row].length) {
			System.out.println();
			return;
		}
		if(row < arr2.length && col < arr2[row].length) {
			printElementArray(row, col+1);
		}

		
		
	}
	
	public static void main(String[] args) {
		//printArray1(0);
		printRowArray(0);

	}

}
