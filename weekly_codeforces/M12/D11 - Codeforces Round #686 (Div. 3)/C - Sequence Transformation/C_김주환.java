package _686;

import java.io.*;
import java.util.*;

public class C_±Ë¡÷»Ø {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			HashMap<Integer, Integer> hs = new HashMap<>();
			int last = -1;

			for (int i = 0; i < n; i++) {
				if (last != arr[i]) {
					hs.put(arr[i], hs.getOrDefault(arr[i], 0) + 1);
				}

				last = arr[i];
			}

			hs.put(arr[0], hs.get(arr[0]) - 1);
			hs.put(arr[n - 1], hs.get(arr[n - 1]) - 1);

			int min = Integer.MAX_VALUE;
			for (int key : hs.keySet()) {
				min = Math.min(min, hs.get(key));
			}

			sb.append(min + 1).append("\n");
		}
		System.out.println(sb.toString());
	}
}
