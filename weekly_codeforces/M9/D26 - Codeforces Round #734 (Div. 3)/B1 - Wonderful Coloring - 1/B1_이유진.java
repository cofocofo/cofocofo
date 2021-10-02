import java.io.*;
import java.util.StringTokenizer;

public class SolutionB1 {
    public static int [] alpha = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        String str;
        for (int t=0; t<T; t++) {
            initAlpha();

            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            counting(str);

            bw.write(solve()+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void initAlpha() {
        for (int i=0; i<26; i++) alpha[i] = 0;
    }

    public static void counting(String str) {
        int size = str.length();
        for (int i=0; i<size; i++) {
            alpha[str.charAt(i)-'a']++;
        }
    }

    public static int solve() {
        int count = 0; // red로 칠해진 개수
        int oneCnt = 0; // 1개인 알파벳의 개수
        for (int n : alpha) {
            if (n == 1) {
                oneCnt++;
            } else if (n > 1) {
                count++;
            }
        }
        count += oneCnt/2;
        return count;
    }
}
