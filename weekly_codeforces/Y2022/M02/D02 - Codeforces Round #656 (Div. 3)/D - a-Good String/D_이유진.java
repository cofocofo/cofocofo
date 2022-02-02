
import java.io.*;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());


        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = br.readLine();

            bw.write(makeGood(s, n/2, 0, 'a') + "\n");

        }
        bw.flush(); bw.close(); br.close();
    }

    // 먼 미래를 보는 계산도 해야 될 듯. (바꿀 개수가 같아도 미래에 그대로 사용되는 경우가 있는데 first==second는 고려되지 않고 있
    // 아마 3번째 케이스!!
    private static int makeGood(String s, int size, int start, char target) {
        if (size == 0) return getChangeCount(s, start, start, target);

//        System.out.println(size + " " + target);
//        System.out.println(s.substring(start, start+size+size));

        int first = getChangeCount(s, start, start+size-1, target);
        int second = getChangeCount(s, start+size, start+size+size-1, target);

        if (first < second) {
            return first + makeGood(s, size/2, start+size, (char) (target+1));
        } else {
            return second + makeGood(s, size/2, start, (char) (target+1));
        }
    }

    private static int getChangeCount(String s, int start, int end, char target) {
        int count = 0;
        for (int i=start; i<=end; i++) {
            if (s.charAt(i) != target) count++;
        }
        return count;
    }
}
