package _690_;

import java.io.*;

public class C_김주환 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			StringBuilder sb = new StringBuilder();
			int x = Integer.parseInt(br.readLine());

			int n = 9;
			while (x != 0) {
				if (n == 0) { // n이 0이 됐는데도 x가 0이 아니다? 이건 못 만드는 숫자임
					sb.setLength(0); // sb에 넣어뒀던거 지우고
					sb.append("1-"); // 나중에 reverse 해야해서 -1을 이렇게 넣음
					break; // 탈출!
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
