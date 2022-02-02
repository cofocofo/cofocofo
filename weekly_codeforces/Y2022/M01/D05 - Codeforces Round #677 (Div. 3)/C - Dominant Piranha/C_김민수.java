package cf677;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int length = sc.nextInt();
            int[] array = new int[length];

            for(int i = 0; i < length; i++) {
                array[i] = sc.nextInt();
            }

            System.out.println(solve(array));
        }
    }

    /**
     * 가장 큰 값을 찾는게 최선이다.
     * 다만 가장 큰 값이 여러 개일 경우, 좌우를 비교하여 먹을 물고기가 있다면 후보가 될 수 있다.
     */
    static int solve(int[] origin) {
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        int candidate = -1;
        for(int i = 0; i < origin.length; i++) {
            if(max < origin[i]) { // 맥스 찾기
                max = origin[i];
                maxIdx = i;

                // 일단 맥스이므로 좌우비교가 필요 없을듯..
                if(maxIdx - 1 >= 0 && origin[maxIdx - 1] < max) { // 좌우 비교
                    candidate = maxIdx;
                } else if(maxIdx + 1 < origin.length && origin[maxIdx + 1] < max) {
                    candidate = maxIdx;
                }
            } else if(max == origin[i]) { // 맥스와 같다면 좌, 우 비교
                maxIdx = i;
                if(maxIdx - 1 >= 0 && origin[maxIdx - 1] < max) {
                    candidate = maxIdx;
                } else if(maxIdx + 1 < origin.length && origin[maxIdx + 1] < max) {
                    candidate = maxIdx;
                }
            }
        }

        return (candidate == -1)? -1 : candidate + 1;
    }
}
