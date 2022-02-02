import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int n = 0;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            int [] p = new int[n];
            int idx = 0;

            HashSet<Integer> set = new HashSet<>();
            int input;

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n*2; i++) {
                input = Integer.parseInt(st.nextToken());
                if (!set.contains(input)) {
                    set.add(input);
                    p[idx] = input;
                    if (++idx == n) break;
                }
            }

            for (int i=0; i<n; i++) {
                bw.write(p[i] + " ");
            }
            bw.newLine();
        }
        bw.flush(); bw.close(); br.close();
    }
}

/**
 * permutation of length n
 * 길이가 n인 순열 : 1 to n (중복X)
 *
 *  순서는 바뀌지 않고 합쳐져있는 리스트가 있는데, 원래의 p를 찾아라
 *
 *  => 처음 나온 숫자만 리스트에 추가하면 됨
 */