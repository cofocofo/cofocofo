import java.util.HashMap;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            long n = sc.nextLong();

            if(isPrime(n)) {
                System.out.println(1);
                System.out.println(n);
                continue;
            } else {
                long k = -1;
                HashMap<Long, Long> numerators = getNumerators(n); //key = 소인수 분해 val = 지수
                long targetKey = -1;
                /**
                 * 360의 경우, 소인수분해하면 2^3, 3^2, 5^1
                 * 따라서 지수가 가장 큰 2를 기준으로, K = 3 (2의 지수)
                 * 배열은 2, 2, 2*3*3*5 이 답
                 */
                for(long key : numerators.keySet()) { // 지수가 가장 큰 소인수 찾기, k = 지수
                    if(k < numerators.get(key)) {
                        k = numerators.get(key);
                        targetKey = key;
                    }
                }
                System.out.println(k);

                if(k == 1) {
                    System.out.println(n);
                } else {
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i < k - 1; i++) { // 찾은 소인수로 계속 나누기
                        sb.append(targetKey).append(" ");
                        n /= targetKey;
                    }

                    sb.append(n);
                    System.out.println(sb);
                }
            }
        }
    }

    static boolean isPrime(long n) {
        if(n == 2) return true;
        if(n % 2 == 0) return false;

        for(int i = 3; i <= Math.sqrt(n); i+= 2) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 시간초과가 여기서 나는 것으로 추측됨
     */
    static HashMap<Long, Long> getNumerators(long input) {
        HashMap<Long, Long> result = new HashMap<>();
        while (input > 1) {
            for(int i = 2; i <= input; i++) {
                if(input % i == 0) {
                    result.put((long) i, result.getOrDefault((long)i, 0L) + 1);
                    input /= i;
                    break;
                }
            }
        }
        return result;
    }
}
