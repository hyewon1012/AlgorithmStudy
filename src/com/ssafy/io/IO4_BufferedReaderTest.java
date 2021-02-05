package com.ssafy.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IO4_BufferedReaderTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < num; i++) {
			System.out.println(Integer.parseInt(st.nextToken()));
		}
	}

}
