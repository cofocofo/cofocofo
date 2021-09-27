package cofocofo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class WonderfulColoring_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int k = Integer.parseInt(temp[1]);
            int[] seq = new int[N];
            int[] cnt = new int[N];
            int[] ks = new int[k + 1];
            ArrayList<Integer>[] check = new ArrayList[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int a = Integer.parseInt(st.nextToken());
                seq[i] = a;
                cnt[a]++;
                if (cnt[a] > k) {
                    cnt[a] = k;
                }
            }

            for (int i = 0; i < N; i++) {
                for(int j = 0; j < ks.length; j++) {
                    //ks[]
                }

            }

        }
    }
}
