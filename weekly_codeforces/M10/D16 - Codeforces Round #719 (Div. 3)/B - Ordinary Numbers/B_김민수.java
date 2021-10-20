import java.util.Scanner;

public class B_김민수 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int a = sc.nextInt();

            if(a < 10) {                //입력이 10보다 작다면 바로 출력
                System.out.println(a);
                continue;
            }

            String str = String.valueOf(a); // 스트링 변환

            int ans = 9 * (str.length() - 1); // (자릿수 - 1) 에 9를 곱함  0 ~ 9 : 9개 | 10 ~ 99 : 9개 | 100 ~ 999 : 9개 ...

            int first = str.charAt(0) - '0';
            int near = 0;

            for(int i = 0; i < str.length(); i++) {
                near += first * Math.pow(10 , i); // 맨 첫자리의 수를 갖는 동일 수 만듬
            }

            if(a >= near) { // 동일 수 보다 같거나 크면 해당 첫자리의 수만큼 더함  만약 near가 3333이면 1111, 2222, 3333 을 가지므로
                ans += first;
            } else {        // 작다면 하나 뺀거 더함
                ans += first - 1;
            }

            System.out.println(ans);
        }
    }
}
