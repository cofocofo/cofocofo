package _686;

import java.io.*;

public class A_±Ë¡÷»Ø {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			int n = Integer.parseInt(br.readLine());

			for (int i = 1; i < n; i++) {
				sb.append(i + 1).append(" ");
			}
			sb.append("1").append("\n");
		}

		System.out.println(sb.toString());
	}

}
