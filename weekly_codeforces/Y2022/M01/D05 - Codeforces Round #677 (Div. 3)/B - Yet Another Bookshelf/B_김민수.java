package cf677;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int length = sc.nextInt();
            int[] array = new int[length];
            int sum = 0;
            boolean isFirstOne = false;
            int firstOneIdx = -1;

            for(int i = 0; i < length; i++) {
                array[i] = sc.nextInt();
                if(isFirstOne == false && array[i] == 1) { // 첫 1이 나오는 인덱스 찾기
                    isFirstOne = true;
                    firstOneIdx = i;
                }
                sum += array[i];
            }

            int lastOneIdx = -1;
            for(int i = length - 1; i > firstOneIdx; i--) { // 마지막 1이 나오는 인덱스 찾기
                if(array[i] == 1) {
                    lastOneIdx = i;
                    break;
                }
            }

            if(sum == 1) {
                System.out.println(0);
                continue;
            }

            int cnt = 0;
            for(int i = firstOneIdx; i <= lastOneIdx; i++) { // 위에서 찾은 첫, 끝 인덱스 사이에서 0의 갯수가 미는 횟수
                if(array[i] == 0) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
