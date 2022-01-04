package _677_;

import java.io.*;

public class B_김주환 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			br.readLine(); // 필요없음

			// 빈칸 제거
			String input = br.readLine().replace(" ", "");
			
			// 1밖에 없으면 0출력
			if (!input.contains("1") || input.indexOf("1") == input.lastIndexOf("1")) {
				sb.append(0).append("\n");
			}
			
			// 1이 처음 나타나는 곳부터 마지막으로 나타나는 곳 까지 자름
			// ▲ 이놈의 길이와 이놈의 길이의 차를 구해서 출력 ▼
			// 문자열에서 0을 제거
			else {
				input = input.substring(input.indexOf("1"), input.lastIndexOf("1"));
				String newInput = input.replace("0", "");
				sb.append(input.length() - newInput.length()).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
