import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_김민수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            boolean[] alpha = new boolean[26]; // 알파벳 체크 배열
            br.readLine();
            String str = br.readLine();
            boolean flag = true; //

            alpha[str.charAt(0) - 'A'] = true; // 첫 글자 true
            for(int i = 1; i < str.length(); i++) { // 두 번째 글자부터..
                int task = str.charAt(i) - 'A'; // 현재 task
                int beforeTask = str.charAt(i - 1) - 'A'; // 이전 task

                if(task == beforeTask) continue; //같으면 넘어감

                if(!alpha[task]){ // 수행되지 않았다면
                    alpha[task] = true;
                } else {          // 수행되었다면
                    flag = false; // 플래그 바꿈
                    System.out.println("no");
                    break;
                }
            }

            if(flag) { // 플래그 체크
                System.out.println("yes");
            }
        }
    }
}
