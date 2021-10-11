import java.util.Scanner;

public class COFO_731_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        outer:
        for (int t = 0; t < T; t++) {
            String s = sc.next();
            if (!isValid(s.toCharArray())) {
                System.out.println("NO");
                continue outer;
            }
            System.out.println("YES");
        }
    }

    //매개변수로 입력받은 문자열 배열이 AS(Alphabetical String)이면 True, 아니면 False 반환
    private static boolean isValid(char[] s) {
        int idx = -1; // a의 위치를 저장하는 변수

        //a의 위치를 찾음.
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'a') {
                idx = i;
                break;
            }
        }

        //만약 a가 없다면 AS가 아니므로 false 반환
        if (idx == -1) return false;

        //a의 위치를 중심으로 투포인터를 확장함.
        int left, right;
        left = right = idx;

        char cur = 'b'; // 다음으로 찾을 문자를 저장함.

        //투 포인터의 범위가 문자열 범위를 포함할 때까지 진행함.
        while ((right - left) < s.length - 1) {
            //만약 왼쪽 다음 포인터가 배열 범위를 벗어나지 않고, 다음 문자와 같으면 왼쪽으로 확장
            if (left - 1 >= 0 && s[left - 1] == cur) {
                left--;
            }
            //만약 오른쪽 다음 포인터가 배열 범위를 벗어나지 않고, 다음 문자와 같으면 오른쪽으로 확장
            else if (right + 1 < s.length && s[right + 1] == cur) {
                right++;
            }
            //포인터가 배열 범위를 벗어나거나, 찾으려는 다음 문자가 없으면 AS가 아니므로 false 반환
            else {
                return false;
            }
            //다음 찾을 문자 변경 A->B->C...
            cur++;
        }

        return true;
    }
}
