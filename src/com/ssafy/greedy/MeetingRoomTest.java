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
		//����ð��� ���ٸ� ���۽ð��� ����������
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
		list.add(m[0]); // ���� �ð��� ������� ȸ�Ǵ� ������ ó������ ����
		
		for (int i = 1, size=m.length; i < size; i++) {
			//��ġ�� �ʴ� ���
			if(list.get(list.size()-1).end <= m[i].start) {
				list.add(m[i]);
			}
		}
		return list;
		
	}

}
