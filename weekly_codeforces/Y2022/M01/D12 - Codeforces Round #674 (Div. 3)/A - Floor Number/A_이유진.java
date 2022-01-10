import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int n, x;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            if (n < 3) {
                bw.write("1\n");
                continue;
            }

            int floor = (n-2)/x + 1;
            if ((n-2)%x > 0) floor++;

            bw.write(floor + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/**
 * Petya의 아파트 번호를 알 때, 몇 층인지 찾기
 */