import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_김민수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] temp = br.readLine().split(" ");
            long N = Long.parseLong(temp[0]);
            long M = Long.parseLong(temp[1]);
            long X = Long.parseLong(temp[2]);

            /**
             * N = 3; M = 5;
               0 1 2 3     0 1 2 3 4
            0  1 4 7 10    1 2 3 4 5
            1  2 5 8 11    6 7 8 9
            2  3 6 9

            */

            long i = X % N == 0 ? N - 1 : (X % N - 1); // row
            long j = X % N == 0 ? (X / N - 1) : (X / N); // column
            long ans =  i * M + j + 1;
수
            System.out.println(ans);
        }
    }
}
