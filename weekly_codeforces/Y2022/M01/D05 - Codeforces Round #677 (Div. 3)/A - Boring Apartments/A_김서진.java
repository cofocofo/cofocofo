import java.io.*;

public class MainA {

	static int T;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		int[] cnt = {1,2,3,4}; // 1,11,111,1111
		
		
		for(int i=0; i<T; i++) {
			String s = br.readLine();
			int answer = 0;
			
			int first = s.charAt(0)-'0'; // 첫번째 자리 수
			
			answer = (first-1)*10; // 1+2+3+4 = 10
			for(int j=0;j<s.length();j++) {
				answer+=cnt[j];
			}
			
			System.out.println(answer);
		}
		// 

	}

}

/*
 * 1~10000번
 * boring : 같은 수로 이루어진 (11,2,777,9999)
 * 1,11,111,1111 => (2,22,222,2222) => 3,33,333,3333 이 순서로 부르는데
 * 주어진 수를 누를 때까지 키를 몇 번 누르는가~?
 */

