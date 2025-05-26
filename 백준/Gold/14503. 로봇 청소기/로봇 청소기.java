import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, M, r, c, d, map[][], deltas[][]={{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
//        robot = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] visited = new int[N][M];
        int cnt = 0;
        while (true) {
            if (visited[r][c] == 0 && map[r][c] == 0) {
                visited[r][c] = ++cnt;
            }
            boolean isClean = false;


            for (int i = 0; i < deltas.length; i++) {
                d = (d + 3) % 4;
                int nr = r + deltas[d][0];
                int nc = c + deltas[d][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if (visited[nr][nc] == 0 && map[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                        isClean = true;
                        break;
                    }
                }
            }

            if (!isClean) {
                int back = (d + 2) % 4;
                int nr = r + deltas[back][0];
                int nc = c + deltas[back][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if (map[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}