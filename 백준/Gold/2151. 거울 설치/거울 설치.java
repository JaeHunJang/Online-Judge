import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, minMirror, deltas[][] = {{1,0},{0,-1},{-1,0},{0,1}};
    static char[][] map;
    static Pos start, end;
    static class Pos {
        int r, c, d, cnt;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Pos(int r, int c, int d, int cnt) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    ", cnt=" + cnt +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = input.charAt(j);
                map[i][j] = ch;
                if (ch == '#') {
                    if (start == null) start = new Pos(i, j);
                    else if (end == null) end = new Pos(i, j);
                }
            }
//            System.out.println(map[i]);
        }
        minMirror = Integer.MAX_VALUE;

//        System.out.println(start);
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Pos> q = new ArrayDeque<>();
        int[][][] visited = new int[4][N][N];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        for (int d = 0; d < 4; d++) {
            q.offer(new Pos(start.r, start.c, d, 0));
            visited[d][start.r][start.c] = 0;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pos cur = q.poll();

                if (cur.r == end.r && cur.c == end.c) {
                    minMirror = Math.min(minMirror, cur.cnt);
                    continue;
                }

                if (map[cur.r][cur.c] == '.' || map[cur.r][cur.c] == '#') {
                    int nr = cur.r + deltas[cur.d][0];
                    int nc = cur.c + deltas[cur.d][1];

                    if (!isIn(nr, nc) || map[nr][nc] == '*' || visited[cur.d][nr][nc] < cur.cnt) continue;
                    visited[cur.d][nr][nc] = cur.cnt;
                    q.offer(new Pos(nr, nc, cur.d, cur.cnt));
                } else if (map[cur.r][cur.c] == '!') {
                    for (int d = 0; d < deltas.length; d++) {
                        if (d == (cur.d + 2) % 4) continue;
                        int nr = cur.r + deltas[d][0];
                        int nc = cur.c + deltas[d][1];

                        if (!isIn(nr, nc) || map[nr][nc] == '*' || visited[d][nr][nc] < cur.cnt) continue;
                        visited[d][nr][nc] = cur.cnt;
                        if (cur.d != d) {
                            q.offer(new Pos(nr, nc, d, cur.cnt + 1));
                        } else {
                            q.offer(new Pos(nr, nc, d, cur.cnt));
                        }
                    }
                }
            }
        }

        return minMirror;
    }

    static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
