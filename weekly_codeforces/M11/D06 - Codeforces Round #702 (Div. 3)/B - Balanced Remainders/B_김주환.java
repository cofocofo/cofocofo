package _702;

import java.io.*;
import java.util.*;

public class B_����ȯ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] remain = new int[3];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				remain[arr[i] % 3]++;
			}

			int cnt = 0;
			// 3�� ���� ������ �� ����
			while (remain[0] != remain[1] || remain[1] != remain[2]) {
				for (int i = 0; i < 3; i++) {
					int from = i;
					int to = (i + 1) % 3;

					// ��� �ѱ��
					while (remain[from] > remain[to]) {
						remain[from]--;
						remain[to]++;
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}
}

/*
3���� �������� ���� �迭�� �޴´�.
�� �� ������ �� ���� �ϳ��� ������ų �� �ִ�.
�ε����� �����ϰ� a�� a+1�� ��ü�Ѵ�.
����� �Ź� �ٸ� move���� �ε��� i�� ���� �� ������ �� �ִ�.

a �迭�� �ִ� ���� 3���� ������ �� �������� 0, 1, 2�� ���� c0, c1, c2��� ����. (����?)
c0, c1, c2�� ������ �����ϰ� �ʹٴ� �� ����

�迭 a�� �뷱�� �°� �ϰ� ���� �� �ʿ��� �ּ� moves��?
*/