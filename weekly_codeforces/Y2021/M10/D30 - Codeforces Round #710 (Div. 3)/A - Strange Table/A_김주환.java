package codeforces._710;

import java.util.*;
import java.io.*;

public class A_김주환 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			long x = Long.parseLong(st.nextToken());

			long floor = (x % n) == 0 ? n : x % n; // 몇층
			long order = (x - floor) / n; // 몇 번째 값
			long answer = ((floor - 1) * m) + order + 1; // 위에서 구한 층과 순서를 이용해 몇번째 값인지 찾음
			System.out.println(answer);
		}
	}
}
