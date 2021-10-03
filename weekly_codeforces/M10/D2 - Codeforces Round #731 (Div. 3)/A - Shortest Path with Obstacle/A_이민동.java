import java.util.Scanner;

public class COFO_731_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int xa = sc.nextInt();
            int ya = sc.nextInt();
            int xb = sc.nextInt();
            int yb = sc.nextInt();
            int xf = sc.nextInt();
            int yf = sc.nextInt();

            //같은 행 또는 같은 열에 위치한다면
            if ((xa == xb && xb == xf) || (ya == yb && yb == yf)) {
                //그리고 시작지와 목적지 사이에 장애물이 존재한다면, 맨하탄 거리 +2
                if ((xa < xf && xf < xb) || (xa > xf && xf > xb) || (ya < yf && yf < yb) || (ya > yf && yf > yb)) {
                    int ret = Math.max(Math.abs(xa - xb), Math.abs(ya - yb));
                    System.out.println(ret + 2);
                } else {
                    System.out.println(Math.abs((xa - xb)) + Math.abs((ya - yb)));
                }
            }
            //같은 행 또는 같은 열에 위치하지 않으면, 장애물 영향 없으므로 맨하탄 거리
            else {
                System.out.println(Math.abs((xa - xb)) + Math.abs((ya - yb)));
            }
        }
    }
}