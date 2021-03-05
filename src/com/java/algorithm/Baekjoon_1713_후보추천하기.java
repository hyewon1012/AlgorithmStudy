package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 일반 정렬(추천횟수, time) -> 추천횟수 같으면 time 큰 순으로 정렬
 * 
 * 인덱스로 값 삽입,삭제 -> List
 * 
 * */
class Candidate {
	int num; //번호
	int cnt; //추천횟수
	public Candidate(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
}

public class Baekjoon_1713_후보추천하기 {
	static int N;
	static int K;
	
	static List<Integer> arr;
	static ArrayList<Candidate> result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 사진틀개수
		K = Integer.parseInt(br.readLine()); // 전체 학생 총 추천횟수
		
		arr = new ArrayList<Integer>();
		result = new ArrayList<Candidate>(); // 출력 리스트
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			arr.add(Integer.parseInt(st.nextToken())); // 추천 리스트
		}
		//3. 추천받은횟수 가장 적은것 삭제(추천횟수 동일한게 두개이상이면 가장 오래된것 삭제) -> 새로운 원소 삽입
		for (int i = 0; i < K; i++) {
			if(result.size() > 0) {
				if(dupCheck(arr.get(i))) {
					continue;
				}
				
			}
			//사진틀 비어 있을때
			if(result.size() < N) {
				result.add(new Candidate(arr.get(i), 1));
				continue;
			}else { //사진틀 꽉찼을때
				
				//현재까지 추천받은횟수가 가장 적은 학생이 두명이상일때 가장 오래된 학생 삭제
				int min = result.get(0).cnt;
				for (int j = 0; j < result.size(); j++) {
					if(min >= result.get(j).cnt) {
						min = result.get(j).cnt;
					}
				}
				
				int cnt = 0;
				for (int j = 0; j < result.size(); j++) {
					if(min == result.get(j).cnt) {
						cnt++;
					}
				}
				
				if(cnt >= 2) {
					result.remove(0);
					result.add(new Candidate(arr.get(i), 1));
				}else {
					//추천횟수 가장 적은거 삭제
					removeItem();
					result.add(new Candidate(arr.get(i), 1));
				}
			}
		}
		
		Collections.sort(result, (o1,o2) -> o1.num - o2.num);
		for (Candidate item : result) {
			System.out.print(item.num+" ");
		}
	}

	private static void removeItem() {
		int min = result.get(0).cnt;
		int idx = -1;
		for (int i = 0; i < result.size(); i++) {
			if(min > result.get(i).cnt) {
				min = result.get(i).cnt;
				idx = i;
			}
		}
		if(idx!=-1) {
			result.remove(idx);
		}
		
	}

	private static boolean dupCheck(int item) {
		for (int i = 0; i < result.size(); i++) {
			if(result.get(i).num == item) {
				result.get(i).cnt++;
				return true;
			}
		}
		return false;
	}

}
