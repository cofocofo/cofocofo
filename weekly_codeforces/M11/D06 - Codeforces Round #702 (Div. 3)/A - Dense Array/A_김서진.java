import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainA {

	    static int T, N;
	    static int[] a;
	    static int cnt;
	    
	    public static void main(String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;

	        T = Integer.parseInt(br.readLine());
	        for (int t = 0; t < T; t++) {
	        	// 입력 처리
	        	N = Integer.parseInt(br.readLine());
	        	a = new int[N];
	        	cnt = 0;
	        	
	        	st = new StringTokenizer(br.readLine());
	        	for (int i = 0; i < N; i++) {
	        		a[i] = Integer.parseInt(st.nextToken());
				}
	        	
	        	// max(a[i],a[i+1]) / min(a[i], a[i+1]) <= 2가 아니라면, 나눈 값이 2의 몇제곱보다 작은지 확읺~!
	        	for(int i=0; i<N-1; i++) {
	        		double cal = (double)Math.max(a[i],a[i+1]) / (double)Math.min(a[i], a[i+1]);
	        		if(cal <= 2) {
	        			continue;
	        		}else {
	        			int num = 2;
	        			while(cal > num) {
	        				num*=2;
	        				cnt++;
	        			}
	        		}
	        	}
	        	
	        	System.out.println(cnt);
	        }
	    }
}
