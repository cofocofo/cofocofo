import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        /**
         * n = 4일 때
         * 2 3 4 1
         * n = 5일 때
         * 2 3 4 5 1
         */
        while (T-- > 0) {
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();

            for(int i = 1; i < n; i++) {
                sb.append(i + 1).append(" ");
            }
            sb.append(1);
            System.out.println(sb);
        }
    }
}
