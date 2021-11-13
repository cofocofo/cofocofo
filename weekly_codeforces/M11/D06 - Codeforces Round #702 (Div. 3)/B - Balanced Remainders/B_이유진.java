import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int n, count, target;
        int [] c = new int [3];
        for (int t=0; t<T; t++) {
            count = 0;
            Arrays.fill(c, 0);

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            int [] a = new int[n];
            st = new StringTokenizer(br.readLine());

            //////////////////////////////////////////////////////

            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                c[a[i]%3]++; // 초기상태의 배열 c
            }

            target = n/3; // c의 값이 target이어야 모든 값이 동일해짐

            int i=0;
            while (c[0] != c[1] || c[1] != c[2]) { // balanced 가 아니면 반복

                // target보다 크면 우측으로 값 넘기기
                if (c[i] > target) {
                    c[(i+1)%3] += c[i]-target;
                    count += c[i]-target; // 움직인 횟수 추가
                    c[i] = target;
                }

                i = (i+1)%3; // 오른쪽으로 이동하면서 탐색
            }

            //////////////////////////////////////////////////////

            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/**
 * B. Balanced Remainders
 * 배열 a, 크기 n (3의배수)
 *
 * 한 번 움직일 때, 배열의 요소를 1 키울 수 있 (a[i]++)
 * 같은 요소 여러번 가능
 *
 * 배열 c : a[i]%3 해서 나오는 0,1,2 의 개수
 *
 * a가 균형이다 == c가 다 같은 값이다. (나머지의 개수가 균일)
 *
 * a를 균형되게 만들 움직임의 최소 횟수를 구해라
 * ---
 * 1. 초기 c를 구함
 * 2. target 값을 구함 (c[i]값)
 * 3. c를 돌면서 target을 넘으면 우측으로 보냄
 */