import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainC {

	static int T;
	static int N;
	static int[] a;
	static long[] dp;
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
        	N = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	a = new int[N+1];
        	for (int i = 1; i <= N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
        	dp = new long[N+2];

        	
        	for(int i=1; i<=N; i++) {
        		int j = i;
        		if(j + a[j] <= N) {
        			dp[j+a[j]] = Math.max(dp[j]+a[j], dp[j+a[j]]);
        			j += a[j];
        		}
        		if(j + a[j] > N) dp[N+1] = Math.max(dp[j]+a[j], dp[N+1]);
        	}
        	
        	System.out.println(dp[1]);
        }
	}
}
