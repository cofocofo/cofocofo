import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// #통곡의벽#비극의시작
// IDEA: 전체 경우의 수 nC2에서 l보다 작은 경우와 r보다 큰 경우를 빼자.
// 같은 코드인데 cpp는 통과, java는 시간 초과

public class COFO_725_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[200010];

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            //평균 O(NlogN), 최악 O(N^2), 아마 여기서 시간초과가 나는 것 같음
            Arrays.sort(arr,0,N);

            //투 포인터를 사용함.

            int left = 0;
            int right = N - 1;
            long ans = 0;
            while (left < right) {
                //두 포인터의 합이 l보다 작다면
                if (arr[left] + arr[right] < l) {
//                  arr[left] + arr[left+1~right] 는 모두 l보다 작다.
                    ans += right-left;
                    left++;
                } else {
                    right--;
                }
            }

            left = 0;
            right = N - 1;
            while (left < right) {
                //두 포인터의 합이 r보다 크다면
                if (arr[left] + arr[right] > r) {
//                  arr[right] + arr[left~right-1] 는 모두 r보다 크다.
                    ans += right - left;
                    right--;
                } else {
                    left++;
                }
            }

            //전체 경우의 수 nC2 - (l보다 작은 합) - (r보다 큰 합)
            bw.write(((long)N*(N-1)/2-ans)+"\n");
        }
        bw.flush();
    }
}