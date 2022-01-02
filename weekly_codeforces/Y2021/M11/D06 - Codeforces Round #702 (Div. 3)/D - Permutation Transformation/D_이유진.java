/**
 * 8분초과 ㅠㅠ
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    static final int MAX_SIZE = 101;
    static int [] a = new int[MAX_SIZE]; // 주어진 것
    static int [] d = new int[MAX_SIZE]; // tree depth 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int n;
        for (int t=0; t<T; t++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            // 초기화
            Arrays.fill(a, 0);
            Arrays.fill(d, 0);

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            //////////////////////////////////////////////////////

            DFS(0, n-1, 0);

            for (int i=0; i<n; i++) {
                bw.write(d[i] + " ");
            }
            bw.newLine();

            //////////////////////////////////////////////////////
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 각 범위 별로 최댓 크기를 갖는 요소를 찾아 depth 기록
     * @param s start index
     * @param e end index
     * @param depth 현재 depth
     */
    static void DFS(int s, int e, int depth) {
        if (e < s) return;

        int index = findMaxIndex(s, e); // 범위 내 최대값 => 노드 당첨!
        d[index] = depth;

        if (s == e) return;

        DFS(s, index-1, depth+1); // 좌측
        DFS(index+1, e, depth+1); // 우측
    }

    /**
     * 범위 내에서 가장 큰 값의 index
     */
    static int findMaxIndex(int s, int e) {
        int index = s;
        int max = a[s];

        for (int i=s+1; i<=e; i++) {
            if (a[i] > max) {
                max = a[i];
                index = i;
            }
        }

        return index;
    }
}

/**
 * D. Permutation Transformation
 *
 * 순열(permutation) 1..n 한 번씩
 * 폴리캅은 트리를 더 좋아함..
 * a 순열을 이진 트리로 바꿈
 *
 * [트리로 바꾸는 방법]
 * 1. 최대 숫자가 root
 * 2. 배열위치에서 좌/우로 최대/최소 찾아서 자식노드
 * 3. d : 각 요소의 depth
 *
 * d 출력
 */
