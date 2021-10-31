import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainA {

    static long T, N, M, X;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Long.parseLong(st.nextToken());
            M = Long.parseLong(st.nextToken());
            X = Long.parseLong(st.nextToken());

            long i = X % N;
            long j = X / N;
            
            // i가 완전히 나누어떨어지면 열의 마지막 위치에 있는 것..
            if(i == 0) {
                j -= 1;
                i = N;
            }

            System.out.println(M * (i-1) + j+1);
        }
    }
}
