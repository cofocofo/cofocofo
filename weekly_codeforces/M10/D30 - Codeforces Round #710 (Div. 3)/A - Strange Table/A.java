package Round710;

import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        long n, m;
        long x;
        long r, c; // x의 좌표
        long y; // by rows (r,c)

        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Long.parseLong(st.nextToken());
            m = Long.parseLong(st.nextToken());
            x = Long.parseLong(st.nextToken());

            r = ((x-1)%n);
            c = ((x-1)/n);

            y = r*m + c + 1;

            bw.write(y + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}

/**
 * 폴리캅은 사각형 테이블 (n*m) 을 찾았음
 * 각 셀은 "by columns"라는 알고리즘을 따르는 수를 갖고 있다.
 * - 1부터 시작
 * - 열기준 좌->우로 넘버링됨, 각 열 내부는 위->아래
 * - 이전 셀보다 1 크게
 *
 * 근데 폴리캅은 불편함을 느낌 (??????)
 * 폴리캅은 "by rows"가 편하다.
 *
 * 폴리캅은 시간이 많이 없다.
 * by columns에서 x번의 수를 갖고 있던 셀이 by rows에서 어떤 숫자를 갖고 있는지 궁금
 */