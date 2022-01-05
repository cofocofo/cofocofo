import java.io.*;
import java.util.StringTokenizer;

public class MainC {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine()); // 200
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine()); 
			int[] p = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxNum = 0;
			int maxIdx = -1;
			
			for (int i = 0; i < N; i++) {
				
				// 제일 크면서 양옆에 먹이가 있다면 이 값과 같은 건 더이상 볼 필요 없음
				if(p[i] <= maxNum) continue;
				
				// 0번째일 때 -> 오른쪽만 비교
				if(i == 0) {
					if(p[i] > p[i+1]) {
						maxNum = p[i];
						maxIdx = i+1;
					}
					continue;
				}
				
				// n-1번째일 때 -> 왼쪽만 비교
				if(i == N-1) {
					if(p[i]>p[i-1]) {
						maxNum = p[i];
						maxIdx = i+1;
					}
					continue;
				}
					
				// 양 옆을 비교해야함! // 5 5 6 6 6 같은 경우 오른쪽만 비교해서는 구할 수 없더라..
				if((p[i] > p[i+1]) || (p[i] > p[i-1])) {
					maxNum = p[i];
					maxIdx = i+1;
				}
			}
			
			System.out.println(maxIdx);
		}
	}
}

/*
 * n개 피라냐 -> 대장은 누구? (다른 애들을 다 먹을 수 있는 애)
 * 왼쪽애보다 크면 왼쪽애 먹고 크기+1, 오른쪽애보다 크면 오른쪽애 먹고 크기+1
 * 한번 움직일 때 옆에 있는 한마리만 먹을 수 있음
 * 대장 피라냐 될 수 있는 한마리만 찾으면 됨.. => 다 먹고 자기만 남으면 dominant.
 * 
 * 물고기 먹어가는거 찾지말고
 * 제일 큰 값 들 중 먹이가 주변에 있는 애를 찾으면 무조건 계속 제일 큰 값이 되므로 대장이 될 수 있다!!
 * 30만번을 모두 검사해도 되려나!
 */

