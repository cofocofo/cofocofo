import java.io.*;
import java.util.StringTokenizer;

public class A_김서진 {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			if(n<=2) System.out.println(1);
			else {
				// 1층이 아닐 경우
				int floor = 1 + (int)((n-2)/x) + ((n-2)%x!=0?1:0); // 1층 + (n-2)/x개 층 + 나머지 있으면 +1층
				System.out.println(floor);
			}
		}
	}

}

