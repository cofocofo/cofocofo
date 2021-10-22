/**
 * Wrong answer on test 2
 * 어디가 틀린 걸까...
 */

package Round719;

import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int x;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());

            bw.write(solve(x) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int n) {
        int length = (int)(Math.log10(n)+1); // 자리수

        // 4자리라면 3자리까지의 경우를 다 더해두기
        int answer = 9*(length-1);

        // 2012라면 2222 가 가능한지 확인
        int d = (int) Math.pow(10, length-1);
        int maxDigit = 0;
        int curDigit;
        while (d > 0) {
            if (maxDigit == 0) {
                maxDigit = n/d;
            } else {
                curDigit = n/d;
                if (maxDigit < curDigit) break; // 2302인 경우 2222 통과 !
                if (maxDigit > curDigit) {
                    maxDigit--; // 최대숫자 하나 줄이기. 2012라면 1111까지 가능하므로
                    break;
                }
            }
            n %= d;
            d /= 10;

        }
        return answer + maxDigit;
    }
}

/**
 * 10진법에서 각 자리의 숫자가 모두 같은 양의 정수를 "ordinary"라 한다.
 *
 * N이 주어졌을 때, 1~N 까지의 숫자 중 ordinary한 숫자의 개수를 구하라.
 *
 * N의 자리수를 구해서 해야겠음
 */