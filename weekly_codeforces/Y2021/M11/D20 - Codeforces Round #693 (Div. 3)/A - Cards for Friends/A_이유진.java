import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int w, h;
        long n;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            n = Long.parseLong(st.nextToken());

            w = cut(w);
            h = cut(h);

            bw.write(w*h >= n ? "YES" : "NO");
            bw.newLine();
        }
        bw.flush(); bw.close(); br.close();
    }

    static int cut(int size) {
        int result = 1;

        while(size%2 == 0) {
            size /= 2;
            result *= 2;
        }
        return result;
    }
}

/**
 * paper : w*h
 * nㄱㅐ가 될 것인가!
 */