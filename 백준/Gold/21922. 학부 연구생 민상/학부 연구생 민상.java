import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 학부 연구생 민상
public class Main {
    static int N, M, count, map[][], visited[][][], deltas[][] = {{-1,0},{0,1},{1,0},{0,-1}}; // 상 우 하 좌
//    static int item[][][] =
//            {{{-1,0},{0,-1},{1,0},{0,1}} // 상 좌 하 우
//            , {{1,0},{0,1},{-1,0},{0,-1}} // 하 우 상 좌
//            , {{0,1},{-1,0},{0,-1},{1,0}} // 우 상 좌 하
//            , {{0,-1},{1,0},{0,1},{-1,0}}}; // 좌 하 우 상
    static int item[][] =
            {{0,3,2,1} // 상 좌 하 우
            , {2,1,0,3} // 하 우 상 좌
            , {1,0,3,2} // 우 상 좌 하
            , {3,2,1,0}}; // 좌 하 우 상


    static List<Pos> aircon;

    static class Pos {
        int r, c, d;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
            d = 0;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[4][N][M];
        aircon = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) aircon.add(new Pos(i, j));
            }
        }

        count = 0;
        for (Pos start : aircon) {
            bfs(start);
        }

        // Todo : visited배열 방문된 곳 전체를 겹쳐서 0 이상인 곳 count하고 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int temp = 0;
                for (int k = 0; k < 4; k++) {
                    if (visited[k][i][j] > 0) temp++;
                }
                if (temp > 0) count++;
            }
        }
        System.out.println(count);
    }

    static void bfs(Pos start) {
        Queue<Pos> q = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            Pos next = new Pos(start.r, start.c);
            next.d = i;
            visited[i][start.r][start.c] = 1;
            q.offer(next);
        }

        while (!q.isEmpty()) {
            // Todo: 4방 탐색 진행
            Pos now = q.poll();
            int nr = now.r + deltas[now.d][0];
            int nc = now.c + deltas[now.d][1];

//            if (map[now.r][now.c] > 0 && map[now.r][now.c] < 9) {
//                int itemNum = map[now.r][now.c]-1;
//                nr = now.r + deltas[item[itemNum][now.d]][0];
//                nc = now.c + deltas[item[itemNum][now.d]][1];
////                nr = now.r + item[itemNum][now.d][0];
////                nc = now.c + item[itemNum][now.d][1];
//                now.d = itemNum;
//            }
//            System.out.println(now);

            if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[now.d][nr][nc] > 0) continue;
            visited[now.d][nr][nc] = 1;

            Pos next = new Pos(nr, nc);
            next.d = now.d;
            if (map[nr][nc] > 0 && map[nr][nc] < 9) {
                next.d = item[map[nr][nc]-1][now.d];
            }

            q.offer(next);

            // Todo: 물건을 만나면 맞는 방향으로 꺽어주고 visited배열 처리
        }
    }

    static void print() {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                System.out.println(Arrays.toString(visited[i][j]));
            }
            System.out.println();
        }
    }
}