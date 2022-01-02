package Round719;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int size;
        String str;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            str = br.readLine();

            bw.write(isSuspicious(str, size) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static String isSuspicious(String str, int size) {
        HashSet<Character> set = new HashSet<>(); // 나왔던 작업 저장
        char task = str.charAt(0); // 이전 작업 저장
        set.add(task);

        for (int i=1; i<size; i++) {
            if (str.charAt(i) == task) continue; // 연달아 같은 작업이면 pass

            task = str.charAt(i); // 작업 변경
            if (set.contains(task)) return "NO"; // 예전에 했었던 작업! -> no
            set.add(task); // 없던 작업 -> 추가
        }
        return "YES";
    }
}

/**
 * Polycarp은 26개의 작업을 갖고 있음 (알파벳 대문자)
 * 수행방식 :
 *  - 작업을 시작하면 끝까지 완료하기 (산만 X)
 *  - 만약 다른 작업으로 바꿨다? 이전 작업으로 못 돌아감
 *  - 하루에 한 문제만 해결할 수 있다. (기록함)
 *
 *  * 선생님은 규칙을 따랐는지 궁금하다.
 *  => 연속적이지 않게 나왔던 알파벳이 나오면 ? false : true
 */