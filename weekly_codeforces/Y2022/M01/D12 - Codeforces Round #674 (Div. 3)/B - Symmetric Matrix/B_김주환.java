package _674_;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_±Ë¡÷»Ø {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			boolean flag = false;
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int a, b;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());

				st = new StringTokenizer(br.readLine());
				b = Integer.parseInt(st.nextToken());
				Integer.parseInt(st.nextToken());

				if (!flag && a == b) {
					flag = true;
				}
			}

			if (m % 2 == 1) {
				flag = false;
			}

			sb.append(flag ? "YES" : "NO").append("\n");
		}

		System.out.println(sb.toString());
	}

}
