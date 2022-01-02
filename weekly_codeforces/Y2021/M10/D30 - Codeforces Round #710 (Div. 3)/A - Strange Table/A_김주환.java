package codeforces._710;

import java.util.*;
import java.io.*;

public class A_����ȯ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			long x = Long.parseLong(st.nextToken());

			long floor = (x % n) == 0 ? n : x % n; // ����
			long order = (x - floor) / n; // �� ��° ��
			long answer = ((floor - 1) * m) + order + 1; // ������ ���� ���� ������ �̿��� ���° ������ ã��
			System.out.println(answer);
		}
	}
}
