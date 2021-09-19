import java.io.*;
import java.util.StringTokenizer;

public class COFO_739_B_WHO_IS_OPPOSITE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int mx = Math.max(a,b);
            int mn = Math.min(a,b);
            int cnt = (mx-mn)*2;
            if(c>cnt || mx>cnt){
                System.out.println("-1");
                continue;
            }
            System.out.println( (c>cnt/2) ? c-(cnt/2) : c+(cnt/2) );
        }
    }
}
