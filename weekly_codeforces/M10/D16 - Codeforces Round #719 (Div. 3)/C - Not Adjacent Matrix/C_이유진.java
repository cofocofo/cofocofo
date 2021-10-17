package Round719;

import java.io.*;
import java.util.StringTokenizer;

public class C {
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

            int [][] matrix = new int[n][n];

            if (make(matrix, n)) { // matrix를 만들 수 있으면 출력
                for (int i=0; i<n; i++){
                    for (int j=0; j<n; j++) {
                        bw.write(String.valueOf(matrix[i][j]));
                        bw.write(" ");
                    }
                    bw.newLine();
                }
            } else { // 만들 수 없다면 -1 출력
                bw.write("-1\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * matrix 만들기
     * @param matrix
     * @param n 한 변의 길이
     * @return 생성 가능 여부
     */
    public static boolean make(int [][] matrix, int n) {
        boolean [] check = new boolean[n*n+1]; // 사용된 숫자 저장 

        for (int i=0; i<n; i++ ) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] > 0) continue;

                int num = getNum(matrix, i, j, check, n*n); // 조건에 맞는 수 받아오기
                if (num == -1) return false; // 만들 수 없음

                matrix[i][j] = num;
                check[num] = true;
            }
        }
        return true;
    }

    /**
     * (i, j) 위치에 넣을 숫자를 얻기 위한 함수
     * @param matrix
     * @param i
     * @param j
     * @param check 사용된 숫자 체크
     * @param m 가능한 가장 큰 숫자 (n*n)
     * @return (i, j) 위치에 넣을 숫자
     */
    public static int getNum(int [][] matrix, int i, int j, boolean [] check, int m) {
        if (m == 1) return 1;

        // 처음 수(1)와 끝 수(m)은 인접한 수가 하나씩 있으므로 모서리를 차지하지 않는게 유리하므로 2부터 시작했음
        int start = 2;

        // 인접 숫자
        int up = 0, left = 0;
        if (i > 0) up = matrix[i-1][j];
        if (j > 0) left = matrix[i][j-1];

        // 시간을 줄이기 위해 인접한 수보다 큰 수에서 시작
        int max = Math.max(up, left);
        if (max > start) {
            if (max + 2 <= m) start = max + 2;
            else start = 1;
        }

        int k=start;

        while (true) {
            if (!check[k]) {
                if (Math.abs(k-up) > 1 && Math.abs(k-left) > 1) return k; // 인접한 수들과 인접한 수가 아니므로 가능!
            }

            if (++k > m) k = 1; // 끝 도달 -> 1로
            if (k == start) break; // 한 바퀴 돌은 것
        }

        return -1; // 없음 ㅠ
    }
}

/**
 * 같은 수는 한 번만 나온다. (1~n^2)
 * 인접한 셀일 때, 숫자는 인접하면 안된다.
 */