import java.io.*;
import java.util.*;

public class Main {
  static int T;
  static List<Integer> list = new ArrayList<>();

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());

    // 1,2,3,4,~9 11,22,33~ 99 111,111,111~999,999,999
    for(int l=1; l<=9; l++){ // 자릿수 1~9개 
      for(int i=1; i<=9; i++){ 
        sb.setLength(0); // 초기화
        for(int j=0; j<l; j++){ 
          sb.append(i); //1~9 // 11~99 // 111~999 
        }
        list.add(Integer.parseInt(sb.toString()));
      }  
    }
  
    sb.setLength(0);
    for(int t=0; t<T; t++){
      int n = Integer.parseInt(br.readLine());

      int cnt = 0;
      for(int el : list){
        if(el <= n) cnt++;
        else break;
      }
      sb.append(cnt).append("\n");
    }
    System.out.println(sb.toString());
  }
}

//
2 6 3
7 1 8
4 9 5