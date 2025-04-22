import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
    static char[][] map;
    static int N, H, D;
    static Pos start, end;
    static class Pos {
        int r, c;
        int h, d;
        int cnt;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
            h = 0;
            d = 0;
            cnt = 0;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'S') start = new Pos(i,j);
                if (map[i][j] == 'E') end = new Pos(i,j);
            }
        }

        bfs();

    }

    static void bfs() {
        Queue<Pos> q = new ArrayDeque<>();
        start.h = H;
        q.offer(start);
        int[][] visited = new int[N][N];
        visited[start.r][start.c] = start.h;

        while (!q.isEmpty()) {
            Pos now = q.poll();

            for (int d = 0; d < deltas.length; d++) {
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue; // 벗어남
                if (map[nr][nc] == 'E') {
                    System.out.println(now.cnt + 1);
                    return;
                }
                Pos next = new Pos(nr, nc);
                next.h = now.h;
                next.d = now.d;
                next.cnt = now.cnt + 1;
                if (map[nr][nc] == 'U') {
                    next.d = D; // 우산 들기
                }
                if (next.d > 0) { // 우산이 있으면 방어
                    next.d--;
                } else { // 우산이 없으면 체력 감소
                    next.h--;
                }
                if (next.h == 0) continue; // 체력 0
                if (visited[nr][nc] >= next.h + next.d) continue;
                visited[nr][nc] = next.h + next.d;
                q.offer(next);
            }
        }

        System.out.println(-1);
    }
}
