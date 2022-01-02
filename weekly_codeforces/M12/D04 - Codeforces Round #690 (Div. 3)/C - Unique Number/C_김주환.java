package _690_;

import java.io.*;

public class C_����ȯ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			StringBuilder sb = new StringBuilder();
			int x = Integer.parseInt(br.readLine());

			int n = 9;
			while (x != 0) {
				if (n == 0) { // n�� 0�� �ƴµ��� x�� 0�� �ƴϴ�? �̰� �� ����� ������
					sb.setLength(0); // sb�� �־�״��� �����
					sb.append("1-"); // ���߿� reverse �ؾ��ؼ� -1�� �̷��� ����
					break; // Ż��!
				}

				if (x >= n) {
					x -= n;
					sb.append(n);
				}
				n--;
			}

			System.out.println(sb.reverse().toString());
		}
	}
}
