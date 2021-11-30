import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainB {

	static int T;
	static int N;
	static int oddcnt, evencnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
        	N = Integer.parseInt(br.readLine());
        	oddcnt = 0;
        	evencnt = 0;
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) oddcnt++;
				else evencnt++;
			}
        	oddcnt = oddcnt == 0? -1 : oddcnt;
        	evencnt = evencnt == 0? -1 : evencnt;
        	
        	if(N%2==0) { 
        		// N이 짝수개일 경우
        		// 1 홀수개 2 홀수개일때 성립 x
        		if(oddcnt % 2 != 0 && evencnt % 2 != 0) {
        			System.out.println("NO"); 
        		}
        		else {
        			System.out.println("YES"); 
        		}
    			continue;
        	}else {
        		// N이 홀수개인 경우
        		// 1이 짝수개 2 홀수개인 경우만 가능
        		if(oddcnt % 2 == 0  && evencnt % 2 != 0) {
        			System.out.println("YES");
        		}else {
        			System.out.println("NO");
        		}
        	}
        }
	}

}

/*
01. 각 사탕은 1gram / 2gram
02. 앨리스와 밥의 사탕 총 무게는 같다
03. 사탕 자르기 불가능
*/