import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainB {

    static int T, N;
    static int[] a;
    static int[] c;
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
        	c = new int[3];
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
        		a[i] = Integer.parseInt(st.nextToken());
        		
        		// switch문 대신 한번에!
        		c[a[i]%3]++;
        		
			}
        	
        	// 기준
        	int target = N/3; // 배열 개수 3의 개수.. 그래서 n/3 항상 자연수
        	for(int i=0; i<3; i++) {
        		
        		if(c[i] <= target) continue; 
        		
        		// c[i] 가 나눠줄 수 있는 정도
        		int diff_i = c[i] - target;
        		
        		
        		for(int j=i+1; j<=i+2; j++) {
        			// i+1, i+2 번째 수들이 기준보다 작으면 나눔~!
	        		if(c[j%3] < target) {
	        			int diff = target - c[j%3];
	        			
	        			// i번째 수가 다 나눠 줄 수 있다면~
	        			if(diff_i >= diff) {
	        				c[i] -= diff;
	        				c[j%3] += diff;
	        				cnt += diff * (j-i);
	        				diff_i -= diff;
	        			}else { // 나눠줄 수 없다면~
	        				c[i] -= diff_i;
	        				c[j%3] += diff_i;
	        				cnt += diff_i * (j-i);
	        				diff_i -= diff_i;
	        			}
	        		}
	        		if(diff_i == 0) break;
        		}
        	}
        	System.out.println(cnt);
        }
    }
	   
}
// 3으로 나눴을때 나머지인 0,1,2 => 개수가 같아야 balanced!
// 한 인덱스를 +1 할 수 있음. 인덱스 위치는 계속 같은 곳일 수 있음
