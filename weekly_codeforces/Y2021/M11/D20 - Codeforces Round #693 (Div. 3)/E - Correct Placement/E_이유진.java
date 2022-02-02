import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int x, y;
        int n;
        boolean isFind;

        Friend [] f = new Friend[200001];
        int [] result = new int[200001];
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                f[i] = new Friend(Math.min(x, y), Math.max(x, y), i+1);
            }

            Arrays.sort(f, 0, n);


            for (int i=0; i<n; i++) {
                isFind = false;
                for (int j=0; j<i; j++) {
                    if (f[i].w <= f[j].w) break;
                    if (f[i].h > f[j].h) {
                        result[f[i].index] = f[j].index;
                        isFind = true;
                        break;
                    }
                }

                if (!isFind) result[f[i].index] = -1;
            }

            for (int i=1; i<=n; i++) {
                bw.write(result[i] + " ");
            }
            bw.newLine();
        }
        bw.flush(); bw.close(); br.close();
    }

    static class Friend implements Comparable<Friend> {
        int w; int h;
        int index;
        Friend (int w, int h, int index) {
            this.w = w; this.h = h; this.index = index;
        }

        @Override
        public int compareTo(Friend o) {
            return this.w > o.w ? 1 : this.w < o.w ? -1 : this.h > o.h ? 1 : this.h == o.h ? 0 : -1;
        }
    }
}
/**
 * 부피가 작은 친구를 앞에 세울 수 있음
 * i번째 친구 앞에 세울 수 있는 j 를 출력하기. 없으면 -1 (각각~)
 * * 답 여러개면 아무거나.
 */