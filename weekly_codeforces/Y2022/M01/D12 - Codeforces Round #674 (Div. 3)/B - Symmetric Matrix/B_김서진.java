import java.io.*;
import java.util.StringTokenizer;

public class B_김서진 {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			boolean isSymmetric = false;
			
			for (int j = 0; j < n; j++) {
				int[][] arr = new int[2][2];
				
				for (int k = 0; k < 2; k++) {
					st = new StringTokenizer(br.readLine());
					arr[k][0] = Integer.parseInt(st.nextToken());
					arr[k][1] = Integer.parseInt(st.nextToken());
				} 
				
				if(arr[0][1] == arr[1][0]) // s[i][j]=s[j][i] 
					isSymmetric = true;
			}
			
			if(isSymmetric) {
				if(m % 2 != 0) {
					System.out.println("NO");
				}else {
					System.out.println("YES");
				}
			}
			else System.out.println("NO");
		}
	}

}

