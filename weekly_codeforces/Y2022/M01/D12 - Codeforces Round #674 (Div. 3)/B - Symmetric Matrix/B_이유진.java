/**
 * 따로따로하면 잘 되는데 (t==1 일 때)
 * 한 번에 하면 답이 이상함
 * -> m에 제대로 된 값이  들어오지 않음
 * -> 아! 홀수 예외처리 할 때 입력을 다 받지 않아서 뒷 부분에 영향이 갔다.
 *
 * test 2 시간초과
 * test 1 틀린 답 ㅎㅎㅎㅎ
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    static final int MAX = 100;
    static int [][] tile = new int[MAX*2][2];
    static int [][] matrix = new int[MAX][MAX];
    static int n, m;
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t=0; t<T; t++) {
            isPossible = false;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for (int i=0; i<n*2; i++) Arrays.fill(tile[i], 0);
            for (int i=0; i<m; i++) Arrays.fill(matrix[i], 0);

            for (int i=0; i<2*n; i++) {
                st = new StringTokenizer(br.readLine());
                tile[i][0] = Integer.parseInt(st.nextToken());
                tile[i][1] = Integer.parseInt(st.nextToken());
            }

//            System.out.println("\n n : " + n + " m : " + m);

            if (m %2 == 0) makeMatrix(0, 0); // 짝수일때만

            bw.write(isPossible ? "YES\n" : "NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void makeMatrix(int r, int c) {

        for (int k=0; k<2*n; k+=2) {
//            System.out.println(k+" " + r + " " + c);
            if (tileIn(r, c, k)) {
                // 대각선타일이 비어있다면 넣고 오기
                if (matrix[c][r] == 0) {
                    for (int l=0; l<2*n; l+=2) {
                        if (tileIn(c, r, l)) {
                            // 다음 타일 붙히러 ~
                            if (r + 2 < m) makeMatrix(r+2, c);
                            else if (c + 2 < m) makeMatrix(c+2, c+2);
                            else isPossible = true;

                            if (isPossible) return;
                        }
                    }
                } else {
                    // 다음 타일 붙히러 ~
                    if (r + 2 < m) makeMatrix(r+2, c);
                    else isPossible = true;

                    if (isPossible) return;
                }
            }
            tileOut(r, c, k);
        }
    }

    private static boolean tileIn(int r, int c, int k) {
        for (int i=0; i<2; i++) {
            for (int j=0; j<2; j++) {
                matrix[r+i][c+j] = tile[k+i][j]; // 타일 넣기

                if (matrix[c+j][r+i] != 0 && matrix[r+i][c+j] != matrix[c+j][r+i]) return false; // 대각 일치 X
            }
        }
        return true;
    }

    private static void tileOut(int r, int c, int k) {
        for (int i=0; i<2; i++) {
            for (int j=0; j<2; j++) {
                matrix[r+i][c+j] = 0; // 타일 빼기
            }
        }
    }
}
