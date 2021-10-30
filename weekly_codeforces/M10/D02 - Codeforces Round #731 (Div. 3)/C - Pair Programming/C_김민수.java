import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C_김민수 {
    static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Integer> a = new LinkedList<>();
            Queue<Integer> b = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b.add(Integer.parseInt(st.nextToken()));
            }

            ArrayList<Integer> ans = solve(a, b);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ans.size(); i++) {
                sb.append(ans.get(i)).append(" ");
            }
            System.out.println(sb.toString().trim());

        }
    }

    static ArrayList<Integer> solve(Queue<Integer> a, Queue<Integer> b) {
        ArrayList<Integer> ans = new ArrayList<>(); // 맞았을 때 리턴할 arraylist
        ArrayList<Integer> no = new ArrayList<>(); // 틀렸을 때 리턴할 arraylist
        no.add(-1);

        while (!a.isEmpty() || !b.isEmpty()) {
            boolean fa = false, fb = false; // a, b의 플래그 설정

            if (!a.isEmpty()) {
                int aa = a.peek();
                if (aa == 0) { // 0이면 추가, k + 1
                    ans.add(a.poll());
                    k++;
                } else if (aa <= k) {
                    ans.add(a.poll());
                } else {
                    fa = true; // k보다 크면 플래그 on
                }
            } else {
                fa = true; // 이 else가 없으면 a가 비어있는데 bb > k 이면
            } // fa = false, fb = true 그래서 마지막 no를 리턴하는 if에 안걸리게됨

            if (!b.isEmpty()) { // 위 로직과 같음
                int bb = b.peek();
                if (bb == 0) {
                    ans.add(b.poll());
                    k++;
                } else if (bb <= k) {
                    ans.add(b.poll());
                } else {
                    fb = true;
                }
            } else {
                fb = true;
            }

            if (a.isEmpty() && b.isEmpty()) { // 먼저 두 큐가 모두 비어있는지 체크
                break; // 왜냐하면, 둘다 비어있어도 두 플래그는 true 이기 때문
            } // 근데 더 좋은 로직이 있을 듯..

            if (fa && fb) { // 그후 플래그 체크
                return no;
            }

        }
        return ans;
    }
}
