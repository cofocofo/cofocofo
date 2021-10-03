import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_김민수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();
            int s = -1; // 시작 포인터
            int e = -1; // 끝 포인터
            int cur = 0; // 알파벳 값 'a' = 0으로 시작

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'a') { // a를 찾으면 거기서부터 시작
                    s = e = i; // 포인터 세팅
                }
            }

            if (s == -1) { // a를 못찾으면 no 출력
                System.out.println("NO");
                continue;
            }

            for (int i = 1; i < str.length(); i++) { // 스트링 전체 탐색
                if (s - 1 >= 0 && str.charAt(s - 1) - 'a' == cur + 1) { // 시작 포인터 전의 알파벳 값과 (현재 값 + 1) 비교
                    s--;
                    cur++;
                } else if (e + 1 < str.length() && str.charAt(e + 1) - 'a' == cur + 1) { // 끝 포인터 뒤의 알파벳 값과 (현재 값 + 1)
                                                                                         // 비교
                    e++;
                    cur++;
                }
            }

            if (cur == str.length() - 1) { // a가 0이므로 전체 탐색 후 값은 스트링 길이의 -1이 돼야 맞음
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
