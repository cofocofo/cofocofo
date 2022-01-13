package virtual;

import java.util.Scanner;

public class C {
    /**
     * action을 했을 때 배열의 합이 n 이상이 되어야 한다. (중요)
     * 따라서 action을 하나씩 할 때 마다 합의 최댓값을 구한다.
     * 이때 규칙이
     * 0 => 1
     *
     * 1 => 2
     * 2 => 4
     * 3 => 6
     * 4 => 9
     * 5 => 12
     * 6 => 16
     * 7 => 20
     * ...
     *
     * 즉 최댓값이 +2 +2 +3 +3 +4 +4 ... 으로 늘어난다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            if(n == 1) {
                System.out.println(0);
                continue;
            }

            int cnt = 1;
            int start = 1;
            int sum = 0;
            while (true) {

                sum += start;
                if(cnt % 2 == 1) {
                    start++;
                }

                if(sum >= n) {
                    System.out.println(cnt);
                    break;
                }
                cnt++;
            }
        }
    }
}
