import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainC {

	    static int T;
	    static long x;
	    
	    public static void main(String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        T = Integer.parseInt(br.readLine());
	        for (int t = 0; t < T; t++) {
	        	// 입력 처리
	        	x = Long.parseLong(br.readLine());
	        	boolean check = false;
	        	
	        	// 3제곱이니깐 a,b는 10^4 미만
	        	for(long i=1; i<10000; i++) {
	        		long a = i*i*i;
	        		
	        		if(x-a<=0) break;
	        		// B가 있는지 찾기!
	        		// 1~10000-i 사이의 값의 세제곱이 x-a와 같은게 있으면 true!
	        		check = findB(x-a, 1, 100000-i);
	        		
	        		if(check) {
	        			System.out.println("YES");
	        			break;
	        		}
	        	}
	        	if(!check) System.out.println("NO");
	        }
	    }

		private static boolean findB(long target, long start, long end) {			
			
			while(start <= end) {
				long mid = (start + end) / 2;
				long b = mid*mid*mid;
				
				if(target == b) return true;
				if(target > b) start = mid +1;
				else end = mid-1;
			}
			return false;
		}
	   
}

// a^3 + b^3 = x a,b 자연수일때~ 가능한지~
// x => 10^12
// 3제곱이니깐 a,b는 10^4 미만

