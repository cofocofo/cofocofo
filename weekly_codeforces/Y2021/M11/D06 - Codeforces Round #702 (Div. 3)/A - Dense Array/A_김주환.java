package _702;

import java.io.*;
import java.util.*;

public class A_����ȯ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int needCnt = 0;
			for (int i = 0; i < N - 1; i++) {
				int num = arr[i];
				// ���� �ε����� ���� ���� 2�躸�� �� Ŭ�� ������ while��
				while (num * 2 < arr[i + 1]) {
					needCnt++;
					num *= 2;
				}

				// ���� �ε����� ���� ���� 2�躸�� �� ���� �� ������ while��
				num = arr[i];
				while (num > arr[i + 1] * 2) {
					needCnt++;
					num = (int) Math.ceil(num / 2.0); // ����!! �ø�ó��
				}
			}

			System.out.println(needCnt);
		}
	}

}

/*
 * n��° ���ҿ� n+1��° ���Ҵ� 2������� ���̰� �����Ѵ�. 
 * �� ��Ģ�� ��Ű�� �迭�� �����ϴٰ� ǥ���Ѵ�. 
 * �������� ���� � �迭�� �־����� �� �̸� �����ϰ� ����� ���� �ּ� ��� ���Ҹ� �߰��ؾ� �ұ�?
 */
