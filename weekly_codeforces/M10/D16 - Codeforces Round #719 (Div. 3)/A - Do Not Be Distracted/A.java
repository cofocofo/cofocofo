import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            boolean[] alpha = new boolean[26];
            br.readLine();
            String str = br.readLine();
            boolean flag = true;

            alpha[str.charAt(0) - 'A'] = true;
            for(int i = 1; i < str.length(); i++) {
                int task = str.charAt(i) - 'A';
                int beforeTask = str.charAt(i - 1) - 'A';
                if(task == beforeTask) continue;
                if(!alpha[task]){
                    alpha[task] = true;
                } else {
                    flag = false;
                    System.out.println("no");
                    break;
                }
            }
            if(flag) {
                System.out.println("yes");
            }
        }
    }
}
