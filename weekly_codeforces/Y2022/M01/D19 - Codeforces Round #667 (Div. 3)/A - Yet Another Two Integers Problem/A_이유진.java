import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int a, b, answer;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            answer = 0;

            if (a < b) {
                // swap (무조건 큰 수를 a로)
                a ^= b;
                b ^= a;
                a ^= b;
            }

            int diff = a-b;
            answer += diff/10;
            if (diff%10 > 0) answer++;

            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/**
 * 한 번 이동, 정수k (1~10) => a += k | a-= k
 * 이동마다 다른 k 값을 사용함
 * a에서 b를 얻고자 함, 최소한의 움직임 횟수를 구해라 !
 * ( 1 <= a, b <= 10^9 ) 숫자크다
 * ----
 * 그냥 계산하면...?
 */

