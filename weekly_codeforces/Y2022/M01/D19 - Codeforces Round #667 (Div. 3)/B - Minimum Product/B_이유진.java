import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int a, b, x, y, n;
        long ans1, ans2;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            ans1 = mul(a,b,x,y,n);
            ans2 = mul(b,a,y,x,n);

            bw.write(Math.min(ans1, ans2) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static long mul(int _a, int _b, int _x, int _y, int n) {
        if (_a-_x >= n) {
            _a -= n;
        } else {
            n -= _a-_x;
            _a = _x;

            // 남은거 b에다가
            if (_b-_y >= n) {
                _b -= n;
            } else {
                _b = _y;
            }
        }

        return (long) _a * _b;
    }
}

/**
 * [Minimum Product]
 * int a,b,x,y (a>=x, b>=y)
 *
 * 다음의 연산을 n번 이상 할 수 없다.
 * - a와 b를 1감소시켜라.
 *   그러나, 이 연산 결과로 a<x, b<y 가 될 수 없다.
 *
 * a*b의 최소 곱을 찾아라.
 * ---
 * 어떤 조합이 제일 곱이 작을지...!
 * 하나라도 숫자를 최대한 작게 만들어야 승산이 있는 듯
 * a, b 중에 더 작은 숫자가 (x or y)될 때까지 가능한 빼주기 !!
 */