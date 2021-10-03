import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A_김민수 {
    static int[][] map;
    static int[] A, B, F;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int maxX, minX, maxY, minY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            br.readLine();
            map = new int[1001][1001];
            A = new int[2];
            B = new int[2];
            F = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 2; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2; i++) {
                F[i] = Integer.parseInt(st.nextToken());
            }
            map[F[0]][F[1]] = -1;

            maxX = Math.max(A[0], B[0]);
            minX = Math.min(A[0], B[0]);
            maxY = Math.max(A[1], B[1]);
            minY = Math.min(A[1], B[1]);

            System.out.println(bfs(A)); // bfs로 접근 그러나 time out..
        }
    }

    static int bfs(int[] cor) {
        Queue<int[]> q = new LinkedList<>();
        q.add(cor);
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == B[0] && now[1] == B[1]) { // 큐에서 뽑은게 B좌표라면 map값을 리턴
                return map[B[0]][B[1]];
            }

            for (int i = 0; i < 4; i++) { // rldu 4방 탐색
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                int[] newCor = { x, y };
                if (!isWall(x, y) && map[x][y] == 0) { // 벽이 아니고 방문하지 않았다면 ( map = 0 ) 현재 맵에서 + 1
                    map[x][y] = map[now[0]][now[1]] + 1;
                    q.add(newCor);
                }
            }
        }
        return -1;
    }

    static boolean isWall(int x, int y) {
        if (x < 0 || x > 1000 || y < 0 || y > 1000) {
            return true;
        }
        return (x < minX - 1 || x > maxX + 1 || y < minY - 1 || y > maxY + 1); // 타임아웃이 생겨 출발지, 도착지를 기준으로 새로운 바운더리 체크
    }
}
