package _677_;

import java.io.*;

public class B_����ȯ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			br.readLine(); // �ʿ����

			// ��ĭ ����
			String input = br.readLine().replace(" ", "");
			
			// 1�ۿ� ������ 0���
			if (!input.contains("1") || input.indexOf("1") == input.lastIndexOf("1")) {
				sb.append(0).append("\n");
			}
			
			// 1�� ó�� ��Ÿ���� ������ ���������� ��Ÿ���� �� ���� �ڸ�
			// �� �̳��� ���̿� �̳��� ������ ���� ���ؼ� ��� ��
			// ���ڿ����� 0�� ����
			else {
				input = input.substring(input.indexOf("1"), input.lastIndexOf("1"));
				String newInput = input.replace("0", "");
				sb.append(input.length() - newInput.length()).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
