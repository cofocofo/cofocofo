import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int a=1, b=1, c=1;
        boolean flag;
        for (int t=0; t<T; t++) {
            int [] input = new int[3];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<3; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(input);

            flag = false;

            if (input[1] == input[2]) {
                if (input[0] == input[1]) {
                    flag = true;
                    a = input[2]; b = a; c = a;
                } else if (input[2] >= 2) {
                    flag = true;
                    a = input[2]; b = input[0]; c = input[0];
                }
            }

            if (flag) {
                bw.write("YES\n"+a+" "+b+" "+c+" \n");
            } else {
                bw.write("NO\n");
            }

        }
        bw.flush(); bw.close(); br.close();
    }
}

/**
 * x,y,z : 3 양의정수
 * 양의정수 a,b,c를 찾아라.
 * x = max(a,b)
 * y = max(a,c)
 * z = max(b,c)
 * or 찾을 수 없음..
 *
 */