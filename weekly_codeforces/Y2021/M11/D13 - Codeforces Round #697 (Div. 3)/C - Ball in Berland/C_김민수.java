import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class C_김민수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] tmp = br.readLine().split(" ");
            long k = Long.parseLong(tmp[2]);

            String[] boys = br.readLine().split(" ");
            String[] girls = br.readLine().split(" ");

            HashMap<Integer, Long> boyMap = new HashMap<>();
            HashMap<Integer, Long> girlMap = new HashMap<>();

            for(int i = 0; i < k; i++) {
                int boy = Integer.parseInt(boys[i]);
                int girl = Integer.parseInt(girls[i]);

                if(boyMap.containsKey(boy)) {
                    long a = boyMap.get(boy) + 1;
                    boyMap.put(boy, a);
                } else {
                    boyMap.put(boy, 1L);
                }

                if(girlMap.containsKey(girl)) {
                    long a = girlMap.get(girl) + 1;
                    girlMap.put(girl, a);
                } else {
                    girlMap.put(girl, 1L);
                }
            }

            long redun = 0;

            for (int key : boyMap.keySet()) {
                long value = boyMap.get(key);
                redun += value * (value - 1) / 2;
            }

            for (int key : girlMap.keySet()) {
                long value = girlMap.get(key);
                redun += value * (value - 1) / 2;
            }

            System.out.println(k * (k-1) / 2 - redun);
        }
    }

    /**
     * k 갯수 중 2개를 고르는 경우의 수에서 남자가 중복되는 경우, 여자가 중복되는 경우를 빼면 답이된다.
     * 남자가 중복되는 경우를 찾기 위해 boyMap, 여자가 중복되는 경우를 찾기 위해 girlMap을 사용하여 갯수를 count
     *
     * ex)
     * (1,1) (1,2) (2,3), (3,4) (3, 1) 이라면 k = 5
     *
     * boyMap = {1:2, 2:1, 3:2}  남자가 1인 짝의 갯수 = 2, 2인 짝의 갯수 = 1, ... line: 20 - 37
     * girlMap = {1:2, 2:1, 3:1, 4:1} ...                                 line: 20 - 37
     *
     * 전체 경우의 수 = k * (k - 1) / 2
     *
     * 남자가 중복되는 경우의 수 = 2*(2-1)/2 + 1*(1-1)/2 + 2*(2-1)/2  line: 41 - 44
     * 여자가 중복되는 경우의 수 = ... line: 46 - 49
     */

}
