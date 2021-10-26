import java.util.Scanner;

public class A_김민수{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();
            int[] ary = new int[N];
            int val = 0;
            boolean found = false;

            for(int i = 0; i < N; i++) {
                ary[i] = sc.nextInt();
            }

            for(int i = 0; i < N - 1; i++) {
                if(i == 0) {
                    val = ary[i]; // 맨 처음엔 먼저 저장만
                } else {
                    if(val != ary[i]) {// 현재 값과 저장된 값이 다르면
                        int idx = ary[i+1] == val? i : i - 1; // 다음 값까지 읽고 판단
                        found = true;
                        System.out.println(idx + 1);
                        break;
                    }
                }
            }
            if(!found) // for문 빠져나왔는데 못찾았다면 마지막이 답
                System.out.println(N);
        }
    }
}
