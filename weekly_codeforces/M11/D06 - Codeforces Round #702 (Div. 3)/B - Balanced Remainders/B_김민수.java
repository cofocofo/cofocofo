import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int l = sc.nextInt();

            int[] array = new int[l];
            int[] cs = new int[3];

            for(int i = 0; i < l; i++) {
                array[i] = sc.nextInt();
                int remain = array[i] % 3;
                cs[remain]++;
            }

            int avg = Arrays.stream(cs).sum() / 3;

            int ans = 0;
            int idx = 0;
            while (!(cs[0] == cs[1] && cs[0] == cs[2])) {
                if(cs[idx] > avg) { // c0 -> c1 -> c2 -> c0
                    ans += cs[idx] - avg;
                    cs[(idx + 1) % 3] += cs[idx] - avg;
                    cs[idx] = avg;
                }
                idx = (idx + 1) % 3;
            }
            System.out.println(ans);
        }
    }
}
