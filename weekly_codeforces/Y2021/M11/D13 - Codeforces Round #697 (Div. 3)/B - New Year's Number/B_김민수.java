import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_김민수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if(input < 2020) {
                System.out.println("NO");
                continue;
            }

            boolean isPossible = false;
            int limit = input / 2020; // 2020으로 나눈 몫이 한계점이 된다.

            for(int i = 0; i <= limit; i++) {
                if(2020 * i + 2021 * (limit - i) == input) { // 2020a + 2021b의 꼴로 나타낼 수 있나 없나를 판별
                    isPossible = true;
                    break;
                }
            }
            System.out.println((isPossible) ? "Yes" : "No");
        }
    }
}
