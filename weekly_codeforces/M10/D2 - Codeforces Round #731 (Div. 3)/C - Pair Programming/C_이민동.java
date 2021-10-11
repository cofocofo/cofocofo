import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class COFO_731_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        outer:
        for (int t = 0; t < T; t++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                arr.add(a);
            }

            // monocarp의 작업 list에 polycarp의 작업들을 삽입하는 것. 이 때 polycarp의 작업 순서는 유지가 돼야 함.
            // 만약 0이 오면 새 줄을 추가하는 것이므로 현재 삽입 위치에 바로 추가
            // 그런데 0이 아닌 수가 오면, 바로 삽입하는 것이 아니라, k(현재 존재하는 줄의 수)와 같거나 큰 수여야 삽입이 가능함.

            int idx = 0; //삽입 위치
            int kk = k; //이미 존재하는 line 수
            //m번의 삽입 과정
            for (int cnt = 0; cnt < m; cnt++) {
                int a = sc.nextInt();
                //만약 a가 0이면, 바로 삽입하고, k를 증가시킴.
                if (a == 0) {
                    arr.add(idx, a);
                    kk++;
                }
                //a가 0이 아니면, 입력 받은 작업 번호가 k보다 같거나 클 때까지 삽입 위치를 뒤로 이동시킴.
                else {
                    while (idx < arr.size() && kk < a) {
                        //삽입 위치를 이동하는 중에 0을 만나면 k를 증가시킴
                        if (arr.get(idx) == 0) kk++;
                        idx++;
                    }
                    arr.add(idx, a);
                }
                idx++;
            }

            //작업 리스트를 확인하면서 규칙(작업 번호는 현재 존재하는 줄 수(k)보다 같거나 작아야 함)에 어긋나면 -1
            for (int i = 0; i < n + m; i++) {
                if (arr.get(i) == 0) k++;
                else {
                    if (arr.get(i) > k) {
                        System.out.println(-1);
                        continue outer;
                    }
                }
            }

            //작업 리스트에 문제가 없을 경우 정답 출력
            for (int e : arr)
                System.out.printf("%d ", e);
            System.out.println();
        }
    }
}