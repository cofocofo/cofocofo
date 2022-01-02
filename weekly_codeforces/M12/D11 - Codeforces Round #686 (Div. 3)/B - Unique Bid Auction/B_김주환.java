package _686;

import java.io.*;
import java.util.StringTokenizer;

public class B_김주환 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] part = new int[n + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			// 참가자가 뽑은 숫자 저장
			for (int i = 1; i <= n; i++) {
				part[i] = Integer.parseInt(st.nextToken());
			}

			// 카운팅 정렬
			int[] count = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				count[part[i]]++;
			}

			// 가장 작은 숫자 찾기
			int min = -1;
			for (int i = 1; i <= n; i++) {
				if (count[i] == 1) {
					min = i;
					break;
				}
			}

			int idx = -1;
			if (min != -1) { // 승자가 있으면
				for (int i = 1; i <= n; i++) {
					if (part[i] == min) {
						idx = i; // 인덱스 저장
					}
				}
			}

			sb.append(idx).append("\n");
		}

		System.out.println(sb.toString());
	}
}
