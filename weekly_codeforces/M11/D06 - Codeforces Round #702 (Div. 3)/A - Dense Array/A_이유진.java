import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int n;
        int count;
        int min, max;
        for (int t=0; t<T; t++) {
            count = 0;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            int [] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            //////////////////////////////////////////////////////

            for (int i=0; i<n-1; i++) {
                min = Math.min(a[i], a[i+1]);
                max = Math.max(a[i], a[i+1]);

                // 인접한 두 요소가 dense 2배 이내로 차이가 날 떄까지 추가
                while (min*2 < max) {
                    min *= 2;
                    count++;
                }
            }

            bw.write(count + "\n");

            //////////////////////////////////////////////////////
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/**
 * A. Dense Array
 *  == 두 인접한 요소 중 큰게 작은거보다 두 배 이상 크지 않은 것
 *
 *  식 : max(a[i], a[i+1]) <= min(a[i], a[i+1])
 *
 *  배열을 dense로 만들기 위해 삽입할 숫자의 최소 개수 (a[i], a[i+1] 사이에 넣을 숫자의 개수)
 *
 *  ---
 *  dense가 아니면, while(min<max) {min *= 2; cnt++; }
 */