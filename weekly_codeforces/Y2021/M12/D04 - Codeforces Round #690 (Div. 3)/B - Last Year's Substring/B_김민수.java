package cf1204;

import java.util.Scanner;

public class B {
    static String ans = "2020";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            int l = sc.nextInt();
            boolean flag = false;
            String input = sc.next();

            if(input.equals(ans)) {
                System.out.println("YES");
                continue;
            }

            for(int i = 0; i < l; i++) { // i 시작 인덱스
                int j = l - 4;
                String result = getResult(input, i, j); // input: 입력값, i: 시작 인덱스, j: 제외할 개수 = 전체 길이에서 4를 뺀 값
                if(result.equals(ans)) {
                    flag = true;
                    break;
                }
            }

            System.out.println((flag)? "YES": "NO");
        }
    }

    static String getResult(String input, int sIdx, int number) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            if(i < sIdx || i >= sIdx + number) result.append(input.charAt(i));
        }

        return result.toString();
    }
}
