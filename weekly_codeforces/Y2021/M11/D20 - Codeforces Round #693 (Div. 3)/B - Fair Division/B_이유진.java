import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int [] candy = new int [3]; // n, 1, 2
        for (int t=0; t<T; t++) {
            Arrays.fill(candy, 0);
            st = new StringTokenizer(br.readLine());
            candy[0] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<candy[0]; i++) {
                candy[Integer.parseInt(st.nextToken())]++;
            }

            if (candy[2]%2 == 1 && candy[1] >= 2) {
                candy[2]++;
                candy[1] -= 2;
            }

            if (candy[1]%2 == 0 && candy[2]%2 == 0) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush(); bw.close(); br.close();
    }
}

/**
 * 캔디무게 같게 만들기 => 가능?
 */