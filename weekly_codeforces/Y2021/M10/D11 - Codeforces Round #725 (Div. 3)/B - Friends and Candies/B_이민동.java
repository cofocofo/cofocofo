import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//전체 수열의 합을 원소의 개수로 나눠 떨어지지 않으면 -1
//그리고 평균보다 큰 원소의 개수 세기.
public class COFO_725_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            int sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            if ((sum % N) != 0) {
                System.out.println(-1);
                continue;
            }

            int avg = sum / N;

            int ans = 0;
            for (int i = 0; i < N; i++) {
                if (avg < arr[i]) ans++;
            }

            System.out.println(ans);
        }
    }
}
