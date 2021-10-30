package codeforces._710;

import java.io.*;
import java.util.*;

public class C_김주환 {
	static int sameWordLen;
	static String shorter, longer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			String s1 = br.readLine();
			String s2 = br.readLine();
			
			// 길이가 긴것과 짧은것으로 구분
			longer = s1.length() >= s2.length() ? s1 : s2;
			shorter = s1.length() < s2.length() ? s1 : s2;

			// shorter의 길이를 줄여가며 최대로 겹치는 문자의 수를 구함
			sameWordLen = 0;
			for (int i = shorter.length(); i >= 0; i--) {
				findOverlap(0, i);
				
				// 길이가 긴 순으로 탐색하다가 찾으면 바로 종료
				if (sameWordLen != 0) {
					break;
				}
			}

			System.out.println(s1.length() + s2.length() - (sameWordLen * 2));
		}
	}

	// 중복 찾기
	public static void findOverlap(int idx, int len) {
		if (longer.contains(shorter.substring(idx, idx + len)) || sameWordLen != 0) {
			sameWordLen = len;
			return;
		}

		if (idx + len < shorter.length()) {
			findOverlap(idx + 1, len);
		}
	}
}
