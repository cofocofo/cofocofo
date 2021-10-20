import java.util.Scanner;

public class B {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int a = sc.nextInt();

            if(a < 10) {
                System.out.println(a);
                continue;
            }

            String str = String.valueOf(a);

            int ans = 9 * (str.length() - 1);

            int first = str.charAt(0) - '0';
            int near = 0;

            for(int i = 0; i < str.length(); i++) {
                near += first * Math.pow(10 , i);
            }

            if(a >= near) {
                ans += first;
            } else {
                ans += first - 1;
            }

            System.out.println(ans);
        }
    }
}
