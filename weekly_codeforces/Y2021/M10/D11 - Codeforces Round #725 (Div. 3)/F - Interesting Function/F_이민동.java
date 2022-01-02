import java.util.Scanner;

// 1~r까지의 합에서 1~l까지의 합을 빼는 아이디어로 접근한다면 더 쉽게 풀 수 있었다.

public class COFO_725_F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0; t<T; t++){
            int l = sc.nextInt();
            int r = sc.nextInt();

            int ans = r-l;

            outer:
            while(l<r) {
                while (l % 10 != 9) {
                    l++;
                    if(l==r) break outer;
                }

                while (r % 10 != 0) {
                    r--;
                }

                l/=10;
                r/=10;

                ans+=r-l;
            }

            System.out.println(ans);
        }
    }
}