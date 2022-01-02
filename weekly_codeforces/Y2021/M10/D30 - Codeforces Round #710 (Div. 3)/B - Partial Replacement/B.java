package Round710;

import java.io.*;
import java.util.StringTokenizer;

public class B {
    private static final int MAX_CNT = 50; // n <= 50 이라서 이렇게 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int n, k;
        String s;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            s = br.readLine();

            bw.write(solve(n, k, s) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solve(int n, int k, String s) {
        /**
         * 인덱스(i)에서 '*'->'x' 로 변경할 때, 누적 변경횟수(0~i)의 최소값
         * '*'일 때만 최소값을 저장하고, '.'일 때는 0인 상태로 둔다. ('*'이 k내로 인접해 있는지 파악하기 위함)
         */
        int [] dp = new int [n];

        int cnt; // 최소 변경 회수

        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '*') { // i번째가 '*' 일 때

                cnt = MAX_CNT; // 가능한 최대의 값으로 초기화 (이후 최소값을 쉽게 구하기 위함)

                /**
                 * i의 왼쪽으로 거리가 k인 것들에 대해 변경 횟수의 최소값을 구함
                 */
                for (int j=i-k; j<i; j++) {
                    if (j<0) continue; // 범위 이탈

                    // dp[j] > 0 : s.charAt(j) == '*' 임 ('.'이면 dp[]에 저장을 안 하므로)
                    // dp[j] < cnt : 변경횟수가 최소임 (갱신)
                    if (dp[j]>0 && dp[j] < cnt) cnt = dp[j];
                }
                if (cnt == MAX_CNT) cnt = 0; // 최소값이 갱신되지 않은 것 => 거리가 k인 것들이 '.' 이다.
                dp[i] = cnt+1;
            }
        }
        // s  : *..*..
        // dp : 100200

        int answer = 0;
        for (int i=n-1; i>=0; i--) {
            // 뒤에서 첫번째로 나오는 0이 아닌 수 => 제일 오른쪽에 있는 '*'를 변경하고 얻은 최소값
            if (dp[i] > 0) {
                answer = dp[i];
                break;
            }
        }

        return answer;
    }
}

/**
 * B. 부분 교체
 *
 * input : 숫자 k, 문자열 s(길이 n, {'.', '*'})
 *
 * 일부 '*'을 'x'로 바꿔라
 * - 첫번째 '*'
 * - 마지막 '*'
 * - 두 인접한 교체된 'x'는 k거리를 초과할 수 없음 (즉, 두 x사이에 다른 문자가 k개 이상 있을 수 없다!)
 *
 * 위 조건을 만족하면서 최소한으로 교체되는 '*'의 개수를 구하라.
 *
 * ---------------------------
 * '.' 은 절대 교체될 수 없음
 * 그냥 최대한 멀리 떨어뜨리면서 x로 교체하면 안되나? => 안 된다.
 * ----------------------------
 * DP로 !
*/