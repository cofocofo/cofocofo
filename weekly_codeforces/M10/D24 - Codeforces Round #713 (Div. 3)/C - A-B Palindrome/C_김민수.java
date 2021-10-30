import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C_김민수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String[] temp = br.readLine().split(" ");
            int num0 = Integer.parseInt(temp[0]); // 0 개수
            int num1 = Integer.parseInt(temp[1]); // 1 개수

            String str = br.readLine();
            for(int i = 0; i < str.length(); i++) {
                char in = str.charAt(i);
                if(in == '0') num0--;
                else if(in == '1') num1--;
            }

            String result = makePalin(str, num0, num1);
            System.out.println(result);
        }
    }

    static String makePalin(String in, int num0, int num1) {
        char[] ary = in.toCharArray();
        for(int i = 0; i < ary.length / 2; i++) {
            if(ary[i] == ary[ary.length - 1 - i]) { // 1. 대칭되는 자리의 char이 같다면
                if(ary[i] == '?') { // 1-1. 둘다 ? 라면
                    if(num0 >= 2) {
                        ary[i] = ary[ary.length - i - 1] = '0';
                        num0 -= 2;
                    } else if (num1 >= 2) {
                        ary[i] = ary[ary.length - i - 1] = '1';
                        num1 -= 2;
                    } else {
                        return "-1";
                    }
                }
            } else { // 2. 두 char이 다를 때
                if(ary[i] == '?') { //2-1. 첫 char이 ?
                    char num = ary[ary.length - 1 - i];
                    if(num == '0') {
                        if(num0 > 0) {
                            ary[i] = num;
                            num0--;
                        } else {
                            return "-1";
                        }
                    } else if(num == '1') {
                        if(num1 > 0) {
                            ary[i] = num;
                            num1--;
                        } else {
                            return "-1";
                        }
                    }
                } else if(ary[ary.length - 1 - i] == '?') { //2-2. 뒷 char이 ?
                    char num = ary[i];
                    if(num == '0') {
                        if(num0 > 0) {
                            ary[ary.length - 1 - i] = num;
                            num0--;
                        } else {
                            return "-1";
                        }
                    } else if(num == '1') {
                        if(num1 > 0) {
                            ary[ary.length - 1 - i] = num;
                            num1--;
                        } else {
                            return "-1";
                        }
                    }
                } else { //2-3. 두 char이 다르고 ?도 없으면
                    return "-1";
                }
            }
        }

        if(ary.length % 2 == 1) { // 자릿수 홀수인데 가운데가 ?이면
            if(ary[ary.length / 2] == '?') {
                if(num0 > 0) {
                    ary[ary.length / 2] = '0';
                    num0--;
                }
                else if(num1 > 0){
                    ary[ary.length / 2] = '1';
                    num1--;
                }
                else return "-1";
            }
        }

        if(num0 != 0 || num1 != 0) return "-1";

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ary.length; i++) {
            sb.append(ary[i]);
        }
        return sb.toString();
    }
}
