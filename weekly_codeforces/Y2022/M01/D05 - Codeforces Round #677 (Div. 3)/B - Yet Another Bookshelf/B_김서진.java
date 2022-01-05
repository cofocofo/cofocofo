import java.io.*;
import java.util.StringTokenizer;

public class MainB {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine()); // 200
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine()); 
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			boolean isFirstOne = false;
			int temp0 = 0;
			int answer = 0;

			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken()); // 1/0
				
				if(!isFirstOne) { 
					if(num == 1) isFirstOne = true;
					else continue;
				}
				
				if(num == 0) temp0 += 1;
				else {
					answer += temp0;
					temp0 = 0;
				}
			}
			System.out.println(answer);
		}

	}

}

/*
 * n개 꽂을 수 있는 책장
 * a_i = 1 (책 o) a_i=0(책x). 
 * 책장에는 적어도 하나의 책이 있음
 * 
 * [l:r] 연속적으로 꽂힌 곳..
 * 왼/오로 1칸씩 이동시킬 수 있음. 양 왼/오엔 책 없어야..
 * 최소 움직임을 찾는다.. 연속적으로 꽂히도록.. (책과 책 사이에 gab 없도록)
 * 
 */

// sol : 양 끝 1 사이의 0의 개수만 세면 됨
// 처음 1을 찾고, 그 이후에 그 다음 1까지로의 0의 개수를 더해줌
