package Round710;

import java.io.*;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        String a, b;
        for (int t=0; t<T; t++) {
            a = br.readLine();
            b = br.readLine();

            bw.write(solve(a,b) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * cmp1과 cmp2가 공통으로 갖고 있는 가장 긴 문자열의 길이를 구해서 연산 횟수를 구함
     * 가장 긴 공통 문자열의 길이를 구하는 코드 출처 : https://velog.io/@jkh9615/알고리즘-백준-5582-공통-부분-문자열-Java == LCS
     * @return 해야 할 연산의 횟수
     */
    private static int solve(String cmp1, String cmp2) {
        int len1 = cmp1.length();
        int len2 = cmp2.length();
        int max = 0;
        int[][] map = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(cmp1.charAt(i-1) == cmp2.charAt(j-1)) {
                    map[i][j] = map[i-1][j-1] + 1;
                    max = Math.max(max, map[i][j]);
                }
            }
        }
        return (len1 + len2) - (max*2); // length(a+b) - length(str)*2
    }
}

/**
 * C. Double-ended Strings
 *
 * string a, b (소문자로 구성)
 *
 * 다음 작업들을 아무 순서로 할 수 있다.
 * - a의 길이가 0보다 길면, 첫 번째 문자를 지울 수 있다.
 * - a 0보다 길면, 마지막 문자를 지울 수 있다.
 * - b 0보다 길면, b의 첫번째 문자 이루 수 있
 * - b 0보다 길면, b의 마지막 문자 지울 수 있
 *
 * 위 연산들을 하고 나면 a, b는 Empty가 될 것
 *
 * a와 b가 같게 만들기 위한 최소한의 연산의 횟수를 구하라.
 *
 * 1. 가장 긴 공통문자열 str을 찾는다.
 * 2. length(a+b) - length(str)*2 가 답이지 않을까?
 */