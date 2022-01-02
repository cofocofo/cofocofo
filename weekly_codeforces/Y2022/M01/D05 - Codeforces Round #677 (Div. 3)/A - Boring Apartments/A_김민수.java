package cf677;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int answer;
        while (T-- > 0) {
            int target = sc.nextInt();

            int cycle = target % 10; // 1의 자리
            answer = 10 * (cycle - 1); // 1의 자리의 숫자에 따라 1 + 2 + 3 + 4 반복
            for(int i = 3; i >= 0; i--) { // 자릿수 구하기
                int digits = (int) (target / Math.pow(10, i));
                if(digits != 0) {
                    for(int j = i + 1; j > 0; j--) { // 자릿수만큼 더하기 ex) 222 까지라면 1 + 2 + 3
                        answer += j;
                    }
                    break;
                }
            }
            System.out.println(answer);
        }

    }
}
