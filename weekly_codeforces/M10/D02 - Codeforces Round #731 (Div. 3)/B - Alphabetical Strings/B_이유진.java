package Round731;

import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        String str;
        for (int t=0; t<T; t++) {
            str = br.readLine();

            bw.write(solve(str, str.length()) ? "YES" : "NO");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static boolean solve(String str, int size) {
        if (size == 1) return str.equals("a");

        // two pointers
        int i=0, j=size-1;

        // 첫 번째로 확인할 숫자(단어)
        int alpha = size-1;

        // 양 쪽 끝부터 좁혀오기
        while (i <= j) {
            if (str.charAt(i)-'a' == alpha) {
                alpha--;
                i++;
            } else if (str.charAt(j)-'a' == alpha) {
                alpha--;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
