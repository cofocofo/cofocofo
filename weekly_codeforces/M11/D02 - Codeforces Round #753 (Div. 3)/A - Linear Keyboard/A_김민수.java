import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class A_김민수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            char[] order = br.readLine().toCharArray();

            HashMap<Character, Integer> map = new HashMap<>(); // 알파벳 맵

            int idx = 0;
            for(char i : order) {
                map.put(i, idx++); // 알파벳을 키로 순서 맵핑
            }

            String str = br.readLine();

            int sum = 0;

            for(int i = 0; i < str.length() - 1; i++) {
                sum += Math.abs(map.get(str.charAt(i)) - map.get(str.charAt(i+1))); //맵에서 값을 꺼내와 연산
            }

            System.out.println(sum);
        }
    }
}
