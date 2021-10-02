/**
 * Time limit exceeded on test 5
 */
package Round731;

import java.io.*;
import java.util.StringTokenizer;

public class A_2 {
    static class Pair {
        int x; int y; Pair(int x, int y) {this.x=x; this.y=y;}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int x, y;
        long answer;
        Pair[] cell = new Pair[3]; // A, B, F

        for (int t=0; t<T; t++) {
            br.readLine();
            for (int i=0; i<3; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                cell[i] = new Pair(x, y);
            }

            answer = Math.abs(cell[1].x-cell[0].x) + Math.abs(cell[1].y-cell[0].y);

            /**
             * oneLine() 과 fInside()는 처음에 하나의 함수였는데, 에러찾으려고 쪼개서 테스트하다가 이렇게 됐습니다.
             */
            if (oneLine(cell[0].x, cell[1].x, cell[2].x) && fInside(cell[0].y, cell[1].y, cell[2].y)) {
                answer += 2;
            } else if (oneLine(cell[0].y, cell[1].y, cell[2].y) && fInside(cell[0].x, cell[1].x, cell[2].x)) {
                answer += 2;
            }

            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * a, b, f가 같은 줄에 있는지
     */
    static boolean oneLine(int a, int b, int f) {
        if (a == b && a == f) return true;
        else return false;
    }

    /**
     * a, b 사이에 f가 있는지
     */
    static boolean fInside(int a2, int b2, int f2) {
        if (f2 > a2 && f2 > b2) return false;
        if (f2 < a2 && f2 < b2) return false;

        return true;
    }
}
