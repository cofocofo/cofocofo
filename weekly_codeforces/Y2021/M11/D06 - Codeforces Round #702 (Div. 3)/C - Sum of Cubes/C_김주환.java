package _702;

import java.io.*;
import java.util.*;

public class C_김주환 {
	static final int LIMIT = 10000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			long x = Long.parseLong(br.readLine());
			String answer = "NO";

			for (long i = 1; i <= LIMIT; i++) {
				if (i * i * i > x) break; // 찾아야 하는 값이 a보다 크면 더이상 볼 필요가 없다.
				if (binarySearch(x - i * i * i)) answer = "YES";
			}

			System.out.println(answer);
		}
	}

	public static boolean binarySearch(long target) {
		long left = 1;
		long right = LIMIT;

		while (left <= right) {
			long mid = (left + right) / 2;

			if (mid * mid * mid == target) {
				return true;
			} else if (mid * mid * mid < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false;
	}
}

/*
양수 x가 있습니다. x가 2개의 양수로 이루어진 큐브의 합을 대표하는지 체크하세요.
a^3 + b^3 = x 입니다.

*/

/*
public class C_김주환 {
	static Long[] triple;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init();
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			long x = Long.parseLong(br.readLine());
			String answer = "NO";

			Label: for (int i = 0; i < triple.length; i++) {
				if(triple[i] > x) {
					break;
				}
					
				for (int j = i; j < triple.length; j++) {
					if (binarySearch(x - triple[i])) {
						answer = "YES";
						break Label;
					}
					
					if(triple[i] + triple[j] > x) {
						break;
					}
				}
			}

			System.out.println(answer);
		}
	}

	public static void init() {
		ArrayList<Long> list = new ArrayList<>();
		long limit = (long) Math.pow(10, 12);
		long n = 0;

		for (int i = 1; n < limit; i++) {
			n = (long) Math.pow(i, 3);
			list.add(n);
		}

		triple = list.toArray(new Long[list.size()]);
	}
	
	public static boolean binarySearch(long target) {
		int left = 0;
		int right = triple.length;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(triple[mid] == target) {
				return true;
			} else if(triple[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return false;
	}
}
*/