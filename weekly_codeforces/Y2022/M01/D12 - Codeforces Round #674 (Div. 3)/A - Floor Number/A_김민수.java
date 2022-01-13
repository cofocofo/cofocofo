package virtual;

import java.util.Scanner;

public class A {
    /**
     * 1층에는 무조건 2개의 호실이 있다
     * 그 외에는 x개의 호실이 있으므로
     * 입력 받은 호실에서 -2 이후 x로 나눈 몫을 이용
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            if(n == 1 || n == 2) {
                System.out.println(1);
                continue;
            }

            if((n - 2) % x == 0) {
                System.out.println((n - 2) / x + 1);
            } else {
                System.out.println((n - 2) / x + 2);
            }
        }
    }
}
