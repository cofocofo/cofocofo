package cf1204;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        /**
         * 길이가 7일 때
         * 0 6 1 5 2 4 3 원래 문자열 인덱스를 해당 순서로 출력
         */
        while(T-- > 0) {
            int l = sc.nextInt();
            int[] ary = new int[l];
            int[] result = new int[l];

            for(int i = 0; i < l; i++) {
                ary[i] = sc.nextInt();
            }

            for(int i = 0; i < l / 2; i++) { // 위 예시에서는 [0, , 1, , 2, , ]
                result[i * 2] = ary[i];
            }

            int idx = 1;
            for(int i = l - 1; i > l / 2; i--) { // 위 예시에서는 [ , 6, , 5, , 4]
                result[idx * 2 - 1] = ary[i];
                idx++;
            }
            result[l - 1] = ary[l / 2]; //[ , , , , , ,3]

            StringBuilder sb = new StringBuilder();
            for(int e: result) {
                sb.append(e).append(" ");
            }
            System.out.println(sb);
        }
    }
}
