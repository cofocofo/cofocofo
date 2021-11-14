import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            Long a = sc.nextLong();
            System.out.println(solve(a) ? "Yes" : "NO");
        }
    }

    static boolean solve(Long input) {
        if(input == 1) return false;
        long limit = getCrt(input); // 27 2

        for(int i = 1; i <= limit; i++) {

            long result = getCrt((long) (input - Math.pow(i, 3)));
            if(Math.pow(result, 3) + Math.pow(i, 3) == input) return true;
            if(Math.pow(result+1, 3) + Math.pow(i, 3) == input) return true;
        }
        return false;
    }

    static long getCrt(long a) {
        return (long) Math.pow(a, 0.333333333333);
    }
}
