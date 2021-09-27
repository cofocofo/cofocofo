import java.io.*;
import java.util.StringTokenizer;

public class SolutionA {
    private static int c1 = 0;
    private static int c2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int num;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());

            setCoins(num);

            bw.write(c1+" "+c2+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void setCoins(int num) {
        int c = num/3;
        if (num - 3*c > 3*(c+1)-num) {
            c = c+1;
        }
        c2 = c;
        c1 = num - 2*c;
    }
}
