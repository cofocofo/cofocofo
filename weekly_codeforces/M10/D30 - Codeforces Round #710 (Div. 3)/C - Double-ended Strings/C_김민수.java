import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String astr = br.readLine();
            String bstr = br.readLine();
            char[] a = astr.toCharArray();
            char[] b = bstr.toCharArray();

            int ans = 0;
            if(a.length > b.length) {
                ans = solve(b , astr);
            } else {
                ans = solve(a, bstr);
            }

            System.out.println(a.length + b.length - 2*ans);
        }
    }

    static int solve(char[] srt, String lng) {
        int leng = 0;

        // hello
        // h he hel hell hello e el ell ello l ll llo l lo o
        for(int i = 0; i < srt.length; i++) {
            String srtStr = "";
            for(int j = i; j < srt.length; j++) {
                srtStr += srt[j];
                if(lng.contains(srtStr)) {
                    if(leng < srtStr.length()) leng = srtStr.length();
                    //leng = Math.max(leng, srtStr.length());
                }
            }
        }
        return leng;
    }
}
