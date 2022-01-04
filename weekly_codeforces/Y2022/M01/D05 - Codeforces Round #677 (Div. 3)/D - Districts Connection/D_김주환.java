package _677_;

import java.io.*;
import java.util.*;

public class D_김주환 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testCase; tc++) {
			int size = Integer.parseInt(br.readLine());
			int[] gang = new int[size + 1];
			st = new StringTokenizer(br.readLine());

			int TIGER = 1; // 호랑이파
			int BEAR = -1; // 곰파
			gang[1] = Integer.parseInt(st.nextToken());

			for (int i = 2; i <= size; i++) {
				gang[i] = Integer.parseInt(st.nextToken());

				if (BEAR == -1 && gang[i] != gang[TIGER]) {
					BEAR = i;
				}
			}

			// 곰파가 없으면(= 호랑이파밖에 없으면)
			if (BEAR == -1) { 
				sb.append("NO").append("\n");
			}
			
			// 곰파가 있으면(= 호랑이파 외에 다른 파가 있으면)
			else {
				sb.append("YES").append("\n");

				for (int i = 2; i <= size; i++) {
					// 호랑이파는 곰파랑 이어버려~
					if (gang[i] == gang[TIGER]) {
						sb.append(i).append(" ").append(BEAR).append("\n");
					}
					
					// 호랑이파가 아닌 놈들은 호랑이파랑 이어버려~
					else {
						sb.append(i).append(" ").append(TIGER).append("\n");
					}
				}
			}
		}

		System.out.println(sb.toString());
	}
}
