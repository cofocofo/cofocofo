package virtual;

import java.util.Scanner;

public class B {
    /**
     * 한 변의 길이가 짝수이면서 타일이 ij == ji인 경우는 true
     * 그 외에는 false
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            boolean isPossible = false;

            while (n-- > 0) {
                int[][] tile = new int[2][2];

                for(int i = 0; i < 2; i++) {
                    for(int j = 0; j < 2; j++) {
                        tile[i][j] = sc.nextInt();
                    }
                }
                if(tile[0][1] == tile[1][0]) {
                    isPossible = true;
                }
            }

            if(m % 2 == 1) {
                System.out.println("NO");
                continue;
            }

            System.out.println((isPossible)? "YES" : "NO");
        }
    }
}
