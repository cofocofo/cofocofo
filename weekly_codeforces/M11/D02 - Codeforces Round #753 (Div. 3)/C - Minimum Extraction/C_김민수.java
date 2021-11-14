import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class C_김민수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int length = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] array = new int[length];

            for(int i = 0; i < length; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            int maxMin = Integer.MIN_VALUE;

            /**
             *
             * 입력 받은 array 오름차순으로 정렬
             * 배열을 순회할 때 규칙은
             * 최솟값은 맨 앞값에서 이전까지의 최솟값들의 합을 뺀 것이다.
             *
             * min(n) = array[0] - sum of min(1..n-1)
             * min 값과 maxMin 비교 후 maxMin 출력
             */
            Arrays.sort(array);

            int idx = -1;
            int sum = 0;
            while (++idx < length) {
                int min = array[idx] - sum;
                sum += min;
                if(min > maxMin) maxMin = min;
            }

            System.out.println(maxMin);
        }
    }
}
