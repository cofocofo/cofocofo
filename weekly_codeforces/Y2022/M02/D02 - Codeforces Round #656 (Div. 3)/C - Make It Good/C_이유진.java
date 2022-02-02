import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());


        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int [] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int idx = n-1;

            boolean isDecreasing = true;
            while (idx > 0) {
                if (!isDecreasing && a[idx-1] > a[idx]) {
                    // 오르막 중이여야 되는데 감소한다면 prefix 자를 타이밍
                    break;
                } else if (isDecreasing && a[idx-1] < a[idx]) {
                    // 내리막 시작
                    isDecreasing = false;
                }
                idx--;
            }

            bw.write(idx + "\n");

        }
        bw.flush(); bw.close(); br.close();
    }
}
