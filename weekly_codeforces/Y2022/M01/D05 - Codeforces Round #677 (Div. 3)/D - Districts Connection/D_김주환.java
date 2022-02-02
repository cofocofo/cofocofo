package _677_;

import java.io.*;
import java.util.*;

public class D_����ȯ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testCase; tc++) {
			int size = Integer.parseInt(br.readLine());
			int[] gang = new int[size + 1];
			st = new StringTokenizer(br.readLine());

			int TIGER = 1; // ȣ������
			int BEAR = -1; // ����
			gang[1] = Integer.parseInt(st.nextToken());

			for (int i = 2; i <= size; i++) {
				gang[i] = Integer.parseInt(st.nextToken());

				if (BEAR == -1 && gang[i] != gang[TIGER]) {
					BEAR = i;
				}
			}

			// ���İ� ������(= ȣ�����Ĺۿ� ������)
			if (BEAR == -1) { 
				sb.append("NO").append("\n");
			}
			
			// ���İ� ������(= ȣ������ �ܿ� �ٸ� �İ� ������)
			else {
				sb.append("YES").append("\n");

				for (int i = 2; i <= size; i++) {
					// ȣ�����Ĵ� ���Ķ� �̾����~
					if (gang[i] == gang[TIGER]) {
						sb.append(i).append(" ").append(BEAR).append("\n");
					}
					
					// ȣ�����İ� �ƴ� ����� ȣ�����Ķ� �̾����~
					else {
						sb.append(i).append(" ").append(TIGER).append("\n");
					}
				}
			}
		}

		System.out.println(sb.toString());
	}
}
