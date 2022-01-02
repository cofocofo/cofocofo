import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainB {

    static int T, N, K;
    static String str;
    static int cnt; // 결과값
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // str 길이
            K = Integer.parseInt(st.nextToken());
            str = br.readLine();

            // 처음 * 마지막 * => x로 변환되어야함
            int firstIdx = str.indexOf("*",0);
            int lastIdx = str.lastIndexOf("*", str.length()-1);
            
            // 처음 * == 마지막 * => 1개!
            if(firstIdx == lastIdx) {
            	System.out.println(1);
            	continue;
            }
            // 처음 * - 마지막 * 거리가 K 이하면 x로 변환되어야하는 최소 개수는 2개
            if(lastIdx - firstIdx <= K) {
            	System.out.println(2);
            	continue;
            }
         
            cnt = 2; // firstIdx, lastIdx * => x 변환 값
            findNextX(firstIdx, lastIdx);
            System.out.println(cnt);
        }
    }
    
	private static void findNextX(int i, int j) {
		int start = i;
		int end = j;
		int x = 0;
		
		if(end - start <= K) return; // 종료조건
		
		while(i < start+K) { // 
			if(str.charAt(i+1)!='*') x = i; // 갈 수 있는 최근 위치 저장
			i++;
		}
		// start+k번째에 있는 경우
		if(str.charAt(i)=='*') x = i; 
		cnt++;
		findNextX(x,end);
		
		// start에 그대로 있는 경우
		if(start == i) {
			cnt--;
			// end를 조정
			while(j > end-K) {
				if(str.charAt(j-1)!='*') x = j;
				j--;
			}
			
			if(str.charAt(j)=='*') x = j; 
			cnt++;
			findNextX(start,x);
		}
	}
}
