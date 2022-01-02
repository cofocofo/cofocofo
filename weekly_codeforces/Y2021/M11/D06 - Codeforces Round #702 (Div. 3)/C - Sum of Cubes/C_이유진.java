import java.io.*;
import java.util.StringTokenizer;

public class C {

    static final int SIZE = 10001; // a, b 가 최대 10000이므로
    static long [] n = new long [SIZE]; // 세제곱 된 값 저장

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        long T = Integer.parseInt(st.nextToken());

        long x;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            x = Long.parseLong(st.nextToken());

            //////////////////////////////////////////////////////

            bw.write(solve(x) + "\n");

            //////////////////////////////////////////////////////
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String solve(long x) {
        for (int i=1; i<SIZE; i++) {

            n[i] = (long) Math.pow(i, 3); // 3제곱 값 추가

            if (n[i]*2 < x) continue; // 불가능한 경우

            if (binarySearch(i, x)) return "YES";
        }
        return "NO";
    }

    /**
     * 이진 탐색으로 n[index]와 더해서 x가 되는 수 찾기
     * @param index n[index]와 더해야 함
     * @param x 목표로 하는 숫자
     * @return 더해서 x가 되는지 여부
     */
    static boolean binarySearch(int index, long x) {
        int i = 1;
        int j = index;
        int mid;

        while(i <= j) {
            mid = (i+j)/2;

            if (n[index] + n[mid] > x) {
                j = mid-1;
            } else if (n[index] + n[mid] < x) {
                i = mid+1;
            } else {
                return true;
            }
        }
        return false;
    }
}

/**
 * C. Sum of Cubes
 *
 * 양의 정수 x가 주어짐.
 *
 * (1 <= a, b)
 * a, b가 a^3+b^3=x 를 만족하는지(Representable) 확인하라
 * 있으면 yes 없으면 no
 * ---
 * 1000000000000
 * 1 <= x <= 10^12 니까...
 * 1<= x_3 <= 10^4 이다.
 * 따라서 1<= a, b <= 10^4 으로 해도 될 듯 -> 배열 만들어두기
 */