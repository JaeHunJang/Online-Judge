import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, K, map[][];
    static int deltas[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        ArrayDeque<Pos> q = new ArrayDeque<>();
//        PriorityQueue<Pos> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        q.offer(new Pos(0, 0, 0));
        int[][][] visited = new int[K+1][N][M];
        visited[0][0][0] = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Pos now = q.poll();

                if (now.r == N-1 && now.c == M-1) {
                    return now.dist;
                }

                for (int d = 0; d < deltas.length; d++) {
                    int nr = now.r + deltas[d][0];
                    int nc = now.c + deltas[d][1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (visited[now.k][nr][nc] > 0) continue;
                    Pos next = new Pos(nr, nc, now.k);
                    next.dist = now.dist + 1;
                    if (map[nr][nc] == 1) {
                        if (now.k == K) continue;
                        if (visited[now.k+1][nr][nc] > 0) continue;
                        visited[now.k+1][nr][nc] = next.dist;
                        next.k = now.k + 1;
                    } else {
                        if (visited[now.k][nr][nc] > 0) continue;
                        visited[now.k][nr][nc] = next.dist;
                    }
                    q.offer(next);
                }
            }
        }

        return -1;
    }

    static class Pos {
        int r, c, k, dist;

        public Pos(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.dist = 1;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "r=" + r +
                    ", c=" + c +
                    ", k=" + k +
                    ", dist=" + dist +
                    '}';
        }
    }
}