import java.io.*;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int x, y, n;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int d = getD(n, y-x); // 등차
            int s = y; // 시작하는 수
            int cnt = 1;
            while (cnt < n) {
                s -= d;
                if (s <= 0) {
                    s += d;
                    break;
                }
                cnt++;
            }

            for (int i=0; i<n; i++) {
                bw.write(s+d*i + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getD(int n, int diff) {
        for (int d=1; d<diff; d++) {
            if (diff % d > 0) continue; // 나누어 떨어지지 않음
            if (diff / d + 1 <= n) return d;
        }
        return diff;
    }
}

/**
 * 이 배열을 모르는데, 복구할 수 있다!
 * - n개의 구별되는 양의 정수로 구성됨
 * - x, y (x < y) 두 개를 포함함
 * - 오름차순으로 정렬하면, 등차수열이다 !!
 *
 * 여러 가능한 경우가 있음, 가장 큰 요소가 최소인 배열을 달라
 *
 * => 시작하는 수 찾기, 해당 등차(d)로 배열 n개 담아서 출력
 */
