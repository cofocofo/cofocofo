import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_김서진 {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int maxNum = (int) Math.sqrt(n);
			int answer = (maxNum-1)*2 + (n-maxNum*maxNum)/maxNum + ((n-maxNum*maxNum)%maxNum!=0?1:0);
			System.out.println(answer);
		}
	}


}

//n 보다 작은 가장 큰 제곱수 찾아서 계산해주기
//n보다 작은 가장 큰 제곱수 = a일 때,
//(a*a + (x/a + x%a))로 만들어서, (a-1)개 + (a-1)개 + (x/a)개 + (x%a!=0?1:0)개

