package Round731;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int k, m, n;
        Boolean isChange = true;
        for (int t=0; t<T; t++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            int [] mList = new int[m];
            int [] nList = new int[n];

            // Monocarp's
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<m; i++) mList[i] = Integer.parseInt(st.nextToken());

            // Polycarp's
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) nList[i] = Integer.parseInt(st.nextToken());

            // Save result
            ArrayList<Integer> result = new ArrayList<>();

            /**
             * i : Monocarp의 작업 목록 전용 포인터
             * j : Polycarp의 작업 목록 전용 포인터
             * while() : Monocarp, Polycarp 둘의 작업을 모두 확인할 때까지 반복
             */
            int i=0, j=0;
            while((i < m) || (j < n)) {
                isChange = false; // 이번 턴에 수행한 action이 있는지 체크
                if (i < m) {
                    if (mList[i] == 0) { // 0이 있다면 먼저 추가
                        result.add(0);
                        i++;
                        k++; // 파일의 줄 수 늘리기
                        isChange = true;
                    } else if (mList[i] <= k) { // 현재 가능한 작업
                        result.add(mList[i]);
                        i++;
                        isChange = true;
                    }
                }
                if (j < n) {
                    if (nList[j] == 0) {
                        result.add(0);
                        j++;
                        k++;
                        isChange = true;
                    } else if (nList[j] <= k) {
                        result.add(nList[j]);
                        j++;
                        isChange = true;
                    }
                }
                if (!isChange) break;
            }

            if (result.size() == n+m) { // 모든 작업을 수행한 경우
                for (Integer r : result) bw.write(r+" ");
                bw.newLine();
            } else { // 불가능!
                bw.write("-1\n");
            }
        }
        bw.flush();
        bw.close();
    }
}

/**
 * 처음 : k줄 있음
 * k : [0, 100]
 * m, n : [1, 100]
 * 순서를 정해라
 * 0 : 새 줄 추가
 * n : n번째줄 수정
 */

/** 무조건 0부터 추가 **/