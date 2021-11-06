import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_김민수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] temp = br.readLine().split(" ");
            int leng = Integer.parseInt(temp[0]);
            int K = Integer.parseInt(temp[1]);
            String str = br.readLine();

            ArrayList<Integer> indices = new ArrayList<>();

            char[] s = str.toCharArray();
            for(int i = 0; i < leng; i++) {
                if(s[i] == '*') {
                    indices.add(i);
                }
            }

            if(indices.size() <= 2) {
                System.out.println(indices.size());
                continue;
            }

            int ans = solve(indices, K);

            System.out.println(ans);
        }
    }

    /**
     * '*'의 인덱스가 1, 3, 4, 7, 10
     * k = 3
     * 1, 3 비교 -> 통과
     * 1, 4 비교 -> 통과
     * 1, 7 비교 -> 실패, 따라서 이전 '*'인 4를 바꿈, ans++
     *
     * 4, 7 비교 -> 통과
     * 4, 10 비교 -> 실패, 따라서 이전 '*'인 7을 바꿈, ans++
     *
     * 이후, 맨앞, 맨뒤 별을 바꾸므로 ans + 2
     */
    static int solve(ArrayList<Integer> indices, int K) {
        int ans = 0;

        int idx1 = 0;
        int idx2 = idx1;
        while (++idx2 < indices.size()) {
            int head = indices.get(idx1);
            int next = indices.get(idx2);

            if(next - head > K) {
                ans++;
                idx1 = idx2 - 1;
                idx2 = idx1;
            }
        }

        return ans+2;
    }
}
