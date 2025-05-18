import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, map[][], deltas[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Pos start, end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int d = convDir(Integer.parseInt(st.nextToken()));
        start = new Pos(r, c, d, 0);

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        d = convDir(Integer.parseInt(st.nextToken()));
        end = new Pos(r, c, d, 0);

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(start);
        boolean[][][] visited = new boolean[4][N][M];
        visited[start.d][start.r][start.c] = true;

        while (!q.isEmpty()) {
            Pos now = q.poll();

            if (now.r == end.r && now.c == end.c && now.d == end.d) {
                return now.cnt;
            }

            for (int k = 1; k <= 3; k++) {
                int nr = now.r + deltas[now.d][0] * k;
                int nc = now.c + deltas[now.d][1] * k;
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[now.d][nr][nc]) continue;
                if (map[nr][nc] == 1) break;

                visited[now.d][nr][nc] = true;
                q.offer(new Pos(nr, nc, now.d, now.cnt + 1));
            }

            int ld = (now.d + 3) % 4;
            if (!visited[ld][now.r][now.c]) {
                visited[ld][now.r][now.c] = true;
                q.offer(new Pos(now.r, now.c, ld, now.cnt + 1));
            }

            int rd = (now.d + 1) % 4;
            if (!visited[rd][now.r][now.c]) {
                visited[rd][now.r][now.c] = true;
                q.offer(new Pos(now.r, now.c, rd, now.cnt + 1));
            }
        }

        return -1;
    }

    // 동남서북
    static int convDir(int d) {
        if (d == 1) {
            return 0;
        } else if (d == 2) {
            return 2;
        } else if (d == 3) {
            return 1;
        } else if (d == 4) {
            return 3;
        }

        return -1;
    }

    static class Pos {
        int r, c, d, cnt;

        public Pos(int r, int c, int d, int cnt) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cnt = cnt;
        }
    }
}