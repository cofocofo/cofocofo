package _690_;

import java.io.*;

public class B_±Ë¡÷»Ø {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();

			System.out.println(has2020(input) ? "YES" : "NO");
		}
	}

	public static boolean has2020(String input) {
		if (input.startsWith("2020") || input.endsWith("2020")) {
			return true;
		}

		if (input.startsWith("2") && input.endsWith("020")) {
			return true;
		}

		if (input.startsWith("20") && input.endsWith("20")) {
			return true;
		}

		if (input.startsWith("202") && input.endsWith("0")) {
			return true;
		}

		return false;
	}
}
