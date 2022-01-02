package _702;

import java.io.*;
import java.util.*;

public class A_김주환 {

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
				// 다음 인덱스의 원소 값이 2배보다 더 클때 실행할 while문
				while (num * 2 < arr[i + 1]) {
					needCnt++;
					num *= 2;
				}

				// 다음 인덱스의 원소 값이 2배보다 더 작을 때 실행할 while문
				num = arr[i];
				while (num > arr[i + 1] * 2) {
					needCnt++;
					num = (int) Math.ceil(num / 2.0); // 멈춰!! 올림처리
				}
			}

			System.out.println(needCnt);
		}
	}

}

/*
 * n번째 원소와 n+1번째 원소는 2배까지만 차이가 나야한다. 
 * 이 규칙을 지키는 배열을 빽빽하다고 표현한다. 
 * 빽빽하지 않은 어떤 배열이 주어졌을 때 이를 빽빽하게 만들기 위해 최소 몇개의 원소를 추가해야 할까?
 */
