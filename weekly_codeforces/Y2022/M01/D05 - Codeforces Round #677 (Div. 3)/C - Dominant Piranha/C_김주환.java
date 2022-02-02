package _677_;

import java.io.*;
import java.util.*;

public class C_김주환 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < testCase; tc++) {
			int size = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			int[] fishes = new int[size + 1];
			for (int i = 1; i <= size; i++) {
				fishes[i] = Integer.parseInt(st.nextToken());
			}

			// 가장 큰 값을 찾는 과정 (대신에 근처에 작은놈이 있어야함)
			int maxIdx = 0;
			for (int i = 1; i <= size; i++) {
				if (fishes[i] > fishes[maxIdx]) {
					if (i > 1 && i < size) {
						if (fishes[i] > fishes[i - 1] || fishes[i] > fishes[i + 1]) {
							maxIdx = i;
						}
					} else if (i == 1) {
						if (fishes[i] > fishes[i + 1]) {
							maxIdx = i;
						}
					} else {
						if (fishes[i] > fishes[i - 1]) {
							maxIdx = i;
						}
					}
				}
			}

			sb.append((maxIdx == 0) ? -1 : maxIdx).append("\n");
		}

		System.out.println(sb.toString());
	}
}
