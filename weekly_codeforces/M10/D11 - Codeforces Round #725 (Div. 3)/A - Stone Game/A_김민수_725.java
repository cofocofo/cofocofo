import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_김민수_725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] ary = new int[N];
            String[] temp = br.readLine().split(" ");

            int minI = -1;
            int maxI = -1;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                ary[i] = Integer.parseInt(temp[i]);
                if (ary[i] > max) {
                    max = ary[i];
                    maxI = i;
                }
                if (ary[i] < min) {
                    min = ary[i];
                    minI = i;
                }
            }
            int ans = 0;
                                         // 횟수
            int fromLeftMin = minI + 1;  // 최솟값이 왼쪽에서 제거될 때
            int fromRightMin = N - minI; // 최솟값이 오른쪽에서 제거될 때
            int fromLeftMax = maxI + 1;  // 최댓값이 왼쪽에서 제거될 때
            int fromRightMax = N - maxI; // 최댓값이 오른쪽에서 제거될 때

            int fromLeft = Math.max(fromLeftMax, fromLeftMin); // 왼쪽부터 쭉 제거해 나가면
            int fromRight = Math.max(fromRightMax, fromRightMin); // 오른쪽 부터 쭉 제거해 나가면
            int both = Math.min(fromRightMax, fromLeftMax) + Math.min(fromLeftMin, fromRightMin); // 양쪽에서 제거해 나가면

            ans = Math.min(Math.min(fromLeft, fromRight), both); // 위 3개의 값중 최솟값이 답
            System.out.println(ans);
        }
    }
}
