import java.io.*;
import java.util.StringTokenizer;

public class C {
    static long maxScore = -1;
    static long [] arr = new long [200001];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            for (int i=1; i<=n; i++) arr[i] = 0; // 사용할 것만 초기화
            maxScore = -1;

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) {
                arr[i+1] = Integer.parseInt(st.nextToken());
            }

            setScore();

            bw.write(maxScore + "\n");
        }

        bw.flush(); bw.close(); br.close();
    }

    static void setScore() {
        long next;
        for (int i=n; i>0; i--) {
            next = i + arr[i];
            if (next <= n) arr[i] += arr[(int) next];
            if (arr[i] > maxScore) maxScore = arr[i];
        }
    }
}
/**
 * array a[n] (1 <= i <= n)
 * 시작 i를 선택함. result += a[i], (position change) i <- i+a[i]
 * find maximum score
 * ---
 * 메모이제이션 => 뒤에서부터
 */
