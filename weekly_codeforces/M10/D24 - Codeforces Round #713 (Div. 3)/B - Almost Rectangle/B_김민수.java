import java.util.Scanner;

public class B_김민수 {
    static char[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            map = new char[N][N];

            int x1, x2, y1, y2;
            x1 = x2 = y1 = y2 = -1;

            for(int i = 0; i < N; i++) {
                String s = sc.next();
                for(int j = 0; j < N; j++) {
                    char a = s.charAt(j);
                    map[i][j] = a;
                    if(a == '*') {
                        if(x1 == -1) { // x1 <= x2 항상 참
                            x1 = i;
                            y1 = j;
                        } else {
                            x2 = i;
                            y2 = j;
                        }
                    }
                }
            }

            if(x1 == x2) { // 가로 축이 같을 때
                if(x1 == N -1) {  // 맨 아래일 때
                    map[x1 - 1][y1] = '*';
                    map[x1 - 1][y2] = '*';
                } else {
                    map[x1 + 1][y1] = '*';
                    map[x1 + 1][y2] = '*';
                }
            } else { // 가로축이 다를 때
                if(y1 == y2) {  // 세로축이 같을 때
                    if(y1 == N - 1) {
                        map[x1][y1 - 1] = '*';
                        map[x2][y1 - 1] = '*';
                    } else {
                        map[x1][y1 + 1] = '*';
                        map[x2][y1 + 1] = '*';
                    }
                } else { // 둘다 다를 때 엇갈리게 찍기
                    map[x1][y2] = '*';
                    map[x2][y1] = '*';
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(map[i][j]);
                }
                if(i == N - 1) continue;
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }
}
