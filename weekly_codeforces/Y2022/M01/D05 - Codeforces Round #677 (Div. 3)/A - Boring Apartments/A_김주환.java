package _677_;

import java.io.*;

public class A_±Ë¡÷»Ø {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			String x = br.readLine();
			int sum = (x.charAt(0) - '0' - 1) * 10;
			for (int j = 1; j <= x.length(); j++) {
				sum += j;
			}

			sb.append(sum).append("\n");
		}

		System.out.println(sb.toString());
	}

}
