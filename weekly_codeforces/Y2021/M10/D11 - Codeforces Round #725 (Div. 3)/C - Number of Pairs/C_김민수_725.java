import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class C_김민수_725 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++) {
                int key = Integer.parseInt(st.nextToken());
                if(treeMap.get(key) == null) {
                    treeMap.put(key, 1);
                } else {
                    treeMap.put(key, treeMap.get(key) + 1);
                }
            }

            int ans = 0;

            int[] keys = new int[treeMap.size()]; // key array
            int idx = 0;

            for(Map.Entry<Integer, Integer> entry: treeMap.entrySet()) { // 정렬을 지원하는 tree map
                int k = entry.getKey();
                keys[idx++] = k;
            }

            for(int i = 0; i < keys.length; i++) {
                for(int j = i; j < keys.length; j++) {
                    int sum = keys[i] + keys[j];
                    if(sum > r) {
                        break;
                    }
                    if(sum >= l && sum <= r) {
                        if(i == j) {
                            int num = treeMap.get(keys[i]);
                            ans += (num * (num - 1)) / 2;
                        } else {
                            ans += (treeMap.get(keys[i]) * treeMap.get(keys[j]));
                        }
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
