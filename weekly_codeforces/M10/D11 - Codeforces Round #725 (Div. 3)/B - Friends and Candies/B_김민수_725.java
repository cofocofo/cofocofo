import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_김민수_725 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            int[] ary = new int[N];
            String[] temp = br.readLine().split(" ");

            for(int i = 0; i < N; i++) {
                ary[i] = Integer.parseInt(temp[i]);
                sum += ary[i];
            }

            if(sum % N != 0) { // 총합이 인원수로 나눠 떨어지지 않으면 분배할 수 없음
                System.out.println(-1);
            } else {
                int avg = sum / N;
                int ans = 0;

                for(int i = 0; i < N; i++) {
                    if(avg < ary[i]) ans++; // 평균보다 큰 사탕을 가진 사람
                }

                System.out.println(ans);
            }
        }
    }
}
