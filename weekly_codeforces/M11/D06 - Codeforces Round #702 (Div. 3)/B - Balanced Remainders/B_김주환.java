package _702;

import java.io.*;
import java.util.*;

public class B_김주환 {
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
			// 3개 전부 같아질 때 까지
			while (remain[0] != remain[1] || remain[1] != remain[2]) {
				for (int i = 0; i < 3; i++) {
					int from = i;
					int to = (i + 1) % 3;

					// 블록 넘기기
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
3으로 나눠지는 수와 배열을 받는다.
한 번 움직일 때 원소 하나를 증가시킬 수 있다.
인덱스를 선택하고 a와 a+1을 교체한다.
당신은 매번 다른 move마다 인덱스 i를 여러 번 선택할 수 있다.

a 배열에 있는 값을 3으로 나눴을 때 나머지가 0, 1, 2인 것을 c0, c1, c2라고 하자. (개수?)
c0, c1, c2의 개수를 같게하고 싶다는 것 같음

배열 a를 밸런스 맞게 하고 싶을 때 필요한 최소 moves는?
*/