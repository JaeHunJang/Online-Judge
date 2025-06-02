import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, Tg, Tb, X, B, deltas[][] = {{0,-1},{-1,0},{0,1},{1,0}};
    static char map[][];
    static class Pos {
        int r, c, t;

        public Pos(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Tg = Integer.parseInt(st.nextToken());
        Tb = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        PriorityQueue<Pos> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.t, o2.t));
        int[][] visited = new int[N][M];

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == '*') {
                    q.add(new Pos(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            Pos now = q.poll();

            for (int d = 0; d < deltas.length; d++) {
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if (visited[nr][nc] > 0) continue;

                    int nextTime = now.t + 1;

                    if (map[nr][nc] == '#') {
                        nextTime += Tb;
                    }

                    if (nextTime <= Tg) {
                        q.offer(new Pos(nr, nc, nextTime));
                        visited[nr][nc] = 1; 
                    }

                }
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    sb.append(i+1).append(" ").append(j+1).append("\n");
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

    }
}