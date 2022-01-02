package codeforces._710;

import java.io.*;
import java.util.*;

public class C_����ȯ {
	static int sameWordLen;
	static String shorter, longer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			String s1 = br.readLine();
			String s2 = br.readLine();
			
			// ���̰� ��Ͱ� ª�������� ����
			longer = s1.length() >= s2.length() ? s1 : s2;
			shorter = s1.length() < s2.length() ? s1 : s2;

			// shorter�� ���̸� �ٿ����� �ִ�� ��ġ�� ������ ���� ����
			sameWordLen = 0;
			for (int i = shorter.length(); i >= 0; i--) {
				findOverlap(0, i);
				
				// ���̰� �� ������ Ž���ϴٰ� ã���� �ٷ� ����
				if (sameWordLen != 0) {
					break;
				}
			}

			System.out.println(s1.length() + s2.length() - (sameWordLen * 2));
		}
	}

	// �ߺ� ã��
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
