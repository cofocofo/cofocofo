import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D {
    static int[] ary, depth;
    static boolean[] v;
    static StringBuilder sb;
    static int l;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            l = sc.nextInt();
            ary = new int[l];
            depth = new int[l];
            Arrays.fill(depth, -1);

            v = new boolean[l];
            sb = new StringBuilder();

            int max = Integer.MIN_VALUE;
            int idx = 0;
            for(int i = 0; i < l; i++) {
                int input = ary[i] = sc.nextInt();
                if(input > max) {
                    max = input;
                    idx = i;
                }
            }

            int lv = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(idx);
            depth[idx] = 0;
            v[idx] = true;

            while (!q.isEmpty()) {
                int a = q.poll();

                int left = -1, right = -1;
                if(a - 1 > -1)
                    left = findLeftMaxIndex(a - 1);
                if(a + 1 < l)
                    right = findRightMaxIndex(a + 1);

                if(left != -1) {
                    if(v[left] == false) {
                        v[left] = true;
                        depth[left] = depth[a] + 1;
                        q.add(left);
                    }
                }

                if(right != -1) {
                    if(v[right] == false) {
                        v[right] = true;
                        depth[right] = depth[a] + 1;
                        q.add(right);
                    }
                }
            }

            for(int e : depth)
                sb.append(e).append(' ');
            System.out.println(sb.toString().trim());
        }
    }

    static int findLeftMaxIndex(int index) {
        int max = Integer.MIN_VALUE;
        int idx = -1;

        for(int i = index; i >= 0; i--) {
            if(v[i] == true) break;
            if(ary[i] > max) {
                max = ary[i];
                idx = i;
            }
        }
        return idx;
    }

    static int findRightMaxIndex(int index) {
        int max = Integer.MIN_VALUE;
        int idx = -1;

        for(int i = index; i <= l - 1; i++) {
            if(v[i] == true) break;
            if(ary[i] > max) {
                max = ary[i];
                idx = i;
            }
        }
        return idx;
    }
}
