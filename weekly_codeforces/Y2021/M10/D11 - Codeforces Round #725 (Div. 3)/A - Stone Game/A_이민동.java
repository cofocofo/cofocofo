import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class COFO_725_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            //최대값, 최소값의 위치를 저장하기 위한 변수
            int minIdx = 0;
            int maxIdx = 0;

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[minIdx] > arr[i]) {
                    minIdx = i;
                }
                if (arr[maxIdx] < arr[i]) {
                    maxIdx = i;
                }
            }

            // 0 or N-1 (맨 끝)부터 떨어진 거리
            int minDist = Math.min(minIdx, N - 1 - minIdx);
            int maxDist = Math.min(maxIdx, N - 1 - maxIdx);

            int ans = 0;

            //최솟값이 바깥과 가깝다면,
            if (minDist < maxDist) {
                ans += minDist + 1; //먼저 최솟값의 거리를 더하고,
                ans += Math.min(maxIdx + 1, Math.min(Math.abs(minIdx - maxIdx), maxDist + 1));
            }
            //최댓값이 바깥과 가깝다면,
            else {
                ans += maxDist + 1;
                ans += Math.min(minIdx + 1, Math.min(Math.abs(minIdx - maxIdx), minDist + 1));
            }

            System.out.println(ans);
        }
    }
}
