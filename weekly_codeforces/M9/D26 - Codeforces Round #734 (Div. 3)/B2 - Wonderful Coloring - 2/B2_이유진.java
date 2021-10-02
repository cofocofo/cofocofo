/**
 * [!!! 통과 못 한 코드 !!!] Wrong answer on test 2
 * 가볍게 한 번 보시고 의심 가는 곳 알려주시면 감사하겠습니다..
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SolutionB23 {
    public static int [] a; // sequence
    public static int [] result;
    public static int n;
    public static int k;
    public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static int cnt; // 색칠할 칸의 개수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t=0; t<T; t++) {
            input(br);
            coloring();
            print();
        }
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cnt = 0;

        a = new int[n];
        result = new int[n];

        map.clear();

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());

            if (!map.containsKey(a[i])) { // 처음으로 나온 수
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(a[i], list);
                cnt++;
            } else if (map.get(a[i]).size() < k) { // 최대 k개
                map.get(a[i]).add(i);
                cnt++;
            }
        }
        cnt = (cnt/k)*k;
    }

    public static void coloring() {
        int c=1;

        for (Integer num : map.keySet()) {
            for (Integer n : map.get(num)) {
                result[n] = c;

                c = c%k + 1;

                cnt--;
                if (cnt == 0) break;
            }
        }
    }

    public static void print() {
        for (int i=0; i<n; i++) {
            System.out.printf("%d ", result[i]);
        }
        System.out.println();
    }
}
