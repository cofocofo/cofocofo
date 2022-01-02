package _690_;

import java.io.*;

public class A_±Ë¡÷»Ø {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			int n = Integer.parseInt(br.readLine());

			String[] arr = new String[n];
			String[] input = br.readLine().split(" ");

			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) arr[i] = input[i / 2];
				else arr[i] = input[n - (i / 2) - 1];
			}

			for (int i = 0; i < n; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}
