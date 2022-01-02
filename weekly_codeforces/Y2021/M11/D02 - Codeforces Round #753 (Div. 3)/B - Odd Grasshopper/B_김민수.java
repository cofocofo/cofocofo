import java.util.Scanner;

public class B_김민수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            long start = sc.nextLong();
            long jump = sc.nextLong();

            long result = jump % 4;

            // 점프의 수가 4 미만일 때,
            if(jump < 4) {
                for(int i = 1; i <= jump; i++) {
                    if(start % 2 == 0) {
                        start -= i;
                    } else {
                        start += i;
                    }
                }
                System.out.println(start);
                continue;
            }

            /** 점프의 수가 4 이상일 때
             * 현재 자리가 홀수이면 RLLR RLLR RLLR ... 의 4자리를 묶음으로 하여 합이 0이됨
             * 짝수이면 반대
             *
             * 홀수 일 때
             * 따라서 4로 모듈려 연산을 한 값을 기준으로 최종 값 계산
             * mod -> 1 : RLLR ... R이므로  +맨 뒤값
             * mod -> 2 : RLLR ... RL이므로 -1
             * mod -> 3 : RLLR ... RLL이므로 -1 -맨 뒤값
             *
             * 짝수는 반대이므로 생략
             */

            if(start % 2 == 0) {
                if(result == 1) {
                    start -= jump;
                } else if (result == 2) {
                    start++;
                } else if (result == 3) {
                    start += jump;
                    start++;
                }
            } else {
                if(result == 1) {
                    start += jump;
                } else if (result == 2) {
                    start--;
                } else if (result == 3) {
                    start -= jump;
                    start--;
                }
            }

            System.out.println(start);
        }
    }
}
