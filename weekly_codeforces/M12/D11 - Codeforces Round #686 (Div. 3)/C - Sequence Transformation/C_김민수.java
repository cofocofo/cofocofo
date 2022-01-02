import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            HashMap<Integer, Integer> hashMap = new HashMap<>();

            int[] ary = new int[l];
            for(int i = 0; i < ary.length; i++) {
                ary[i] = Integer.parseInt(st.nextToken());
            }

            // 첫번째 값 저장
            int temp = ary[0];
            hashMap.put(temp, 1);
            // 숫자 chunk로 개수 저장
            // 12212221111이라면
            // 1의 경우 저장 값은 3
            // 2의 경우 저장 값은 2
            for(int i = 1; i < ary.length; i++) {
                if(ary[i] != temp) {
                    hashMap.put(ary[i], hashMap.getOrDefault(ary[i], 0) + 1);
                    temp = ary[i];
                }
            }

            if(hashMap.size() == 1) {
                System.out.println(0);
                continue;
            }

            int min = Integer.MAX_VALUE;

            /**
             * 1. 선택한 숫자가 맨 앞, 맨 뒤에 존재할 경우 -> 저장 값에서 -1
             * 2. 선택한 숫자가 맨 앞, 맨 뒤에 존재하지 않을 경우 -> 저장 값에서 +1
             * 3. 그 외에는 그대로
             * 최솟값 찾기
             */
            for(int key : hashMap.keySet()) {
                int number = hashMap.get(key);
                if(ary[0] == key && ary[l - 1] == key) {
                    number--;
                } else if(ary[0] != key && ary[l - 1] != key) {
                    number++;
                }
                if(number < min) {
                    min = number;
                }
            }

            System.out.println(min);
        }
    }
}
