package com.ssafy.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeetingRoomTest {
	
	static class MeetingRoom implements Comparable<MeetingRoom>{
		int no, start, end;

		public MeetingRoom(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}
		//(1,1,2) (2,3,3) (3,2,3)
		//종료시간이 같다면 시작시간이 빠른순서로
		@Override
		public int compareTo(MeetingRoom o) {
			int diff =  this.end - o.end;
			return diff != 0 ? diff : this.start - o.start;
		}
		
		@Override
		public String toString() {
			return "MeetingRoom [no=" + no + ", start=" + start + ", end=" + end + "]";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		MeetingRoom[] m = new MeetingRoom[N];
		
		for (int i = 0; i < N; i++) {
			m[i] = new MeetingRoom(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		List<MeetingRoom> list = getSchedule(m);
		for (MeetingRoom meetingRoom : list) {
			System.out.println(meetingRoom);
		}

	}
	
	public static List<MeetingRoom> getSchedule(MeetingRoom[] m){
		ArrayList<MeetingRoom> list = new ArrayList<MeetingRoom>();
		Arrays.sort(m);
		list.add(m[0]); // 종료 시간이 가장빠른 회의는 무조건 처음으로 배정
		
		for (int i = 1, size=m.length; i < size; i++) {
			//겹치지 않는 경우
			if(list.get(list.size()-1).end <= m[i].start) {
				list.add(m[i]);
			}
		}
		return list;
		
	}

}
