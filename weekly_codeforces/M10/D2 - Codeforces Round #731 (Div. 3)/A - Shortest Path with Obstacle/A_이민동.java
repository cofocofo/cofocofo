import java.util.Scanner;

public class COFO_731_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int xa = sc.nextInt();
            int ya = sc.nextInt();
            int xb = sc.nextInt();
            int yb = sc.nextInt();
            int xf = sc.nextInt();
            int yf = sc.nextInt();

            if((xa==xb && xb==xf) || (ya==yb && yb==yf)){
                if( (xa<xf && xf<xb) || (xa>xf && xf>xb) || (ya<yf && yf<yb) || (ya>yf && yf>yb)) {
                    int ret = Math.max(Math.abs(xa - xb), Math.abs(ya - yb));
                    System.out.println(ret + 2);
                } else {
                    System.out.println(Math.abs((xa-xb))+Math.abs((ya-yb)));
                }
            } else {
                System.out.println(Math.abs((xa-xb))+Math.abs((ya-yb)));
            }
        }
    }
}