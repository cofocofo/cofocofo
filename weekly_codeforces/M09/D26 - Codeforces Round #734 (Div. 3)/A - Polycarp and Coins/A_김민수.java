import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_김민수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int c1 = 0, c2 = 0;
            if (N == 1) {
                c1 = 1;
            }
            if (N == 2) {
                c1 = 0;
            }

            c1 = N / 3;
            c2 = (N - c1) / 2;

            int check = N - (c1 + 2 * c2);

            if (check != 0) {
                if (check == 1)
                    c1++;
            }
            sb.append(c1 + " " + c2 + "\n");
        }
        System.out.println(sb.toString());
    }
}