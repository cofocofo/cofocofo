import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_김민수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long input = Long.parseLong(br.readLine());

            if(input <= 2) {
                System.out.println("no");
                continue;
            }

            boolean isOdd = false;
            if(input % 2 == 1) { //홀수면 통과
                isOdd = true;
            } else {
                while (input > 2) { // 1, 2를 제외하므로 2보다 클 때,
                    input /= 2; // input을 계속 2로 나눈다.
                    if(input % 2 == 1) { //나눈 결과가 홀수면 통과
                        isOdd = true;
                        break;
                    }
                }
            }

            System.out.println((isOdd)? "yes" : "no");

        }
    }
}
