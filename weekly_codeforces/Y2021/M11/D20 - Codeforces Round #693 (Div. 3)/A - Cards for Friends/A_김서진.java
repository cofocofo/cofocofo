import java.io.*;
import java.util.*;

public class MainA {

	static int T;
	static int w, h, n;
	static int cut;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine());
        	w = Integer.parseInt(st.nextToken());
        	h = Integer.parseInt(st.nextToken());
        	n = Integer.parseInt(st.nextToken());
        	cut = 0;
        	
    		while(true) {
    			if(w%2!=0 && h%2!=0) break;
    			if(w%2==0) {
    				w/=2;
    				cut++;
    			}
    			if(h%2==0) {
    				h/=2;
    				cut++;
    			}
    		}
    		
    		System.out.println( Math.pow(2,cut) >= n ? "YES" : "NO" );
        }
	}

}
