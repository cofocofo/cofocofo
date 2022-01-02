import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            HashSet<Integer> redun = new HashSet<>();
            HashMap<Integer, Integer> uniq = new HashMap<>();
            int n = sc.nextInt();
            int idx = 0;

            while (n-- > 0) {
                idx++;
                int input = sc.nextInt();
                isUniq(input, idx, redun, uniq);
            }

            int min = Integer.MAX_VALUE;
            int targetIdx = -1;
            for(int key: uniq.keySet()) {
                if(key < min) {
                    min = key;
                    targetIdx = uniq.get(key);
                }
            }

            System.out.println((uniq.size() == 0) ? -1 : targetIdx);
        }
    }

    /**
     * 중복되는지 체크
     * 유니크에 있는지 체크
     * 없으면 유니크에 put
     * 리턴 값은 필요없음...
     */
    static boolean isUniq(int input, int idx, HashSet<Integer> redun, HashMap<Integer, Integer> uniq) {
        if(redun.contains(input)) return false;
        if(uniq.containsKey(input)) {
            uniq.remove(input);
            redun.add(input);
            return false;
        } else {
            uniq.put(input, idx);
            return true;
        }
    }
}
