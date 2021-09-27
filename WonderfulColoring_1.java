package cofocofo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WonderfulColoring_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();
            int red = 0;
            int[] alpha = new int[26];
            int single = 0;

            for (int i = 0; i < str.length(); i++) {
                alpha[str.charAt(i) - 'a']++;
            }

            for (int i = 0; i < alpha.length; i++) {
                if (alpha[i] == 1)
                    single++;
                if (alpha[i] >= 2) {
                    red++;
                }
            }

            if (single % 2 == 1) {
                single--;
            }
            red += single / 2;

            sb.append(red + "\n");
        }
        System.out.println(sb.toString());
    }
}