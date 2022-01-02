package cf1204;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] pool = new int[46];
        int idx = 0;
        for(int i = 1; i < 10; i++) {
            pool[++idx] = i;
        }
        int rIdx = 0;
        for(int i = 9; i >= 1; i--) {
            rIdx += i;
            for(int j = 1; j < i; j++) {
                pool[++idx] = Integer.parseInt(j + String.valueOf(pool[rIdx]));
            }
        }
        /**
         * 1 2 3.. 9   19 29 39 49 ... 89   189 289... 789   1789 2789 ... 123456789
         * 9개         8개                   7개                         ... 1개
         */

        while(T-- > 0) {
            int input = sc.nextInt();
            if(input > 45) System.out.println(-1); // 45보다 크면 만들 수 없음
            else {
                System.out.println(pool[input]);
            }
        }
    }
}
