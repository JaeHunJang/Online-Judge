import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, map[][], visited[][], deltas[][] = {{0,-1},{-1,0},{0,1},{1,0}};
    static Queue<Pos> v1, v2, nv1, nv2;
    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
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

        map = new int[N][M];
        visited = new int[N][M];
        v1 = new ArrayDeque<>();
        v2 = new ArrayDeque<>();

        int cnt = N * M;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    v1.offer(new Pos(i, j));
                    visited[i][j] = 1;
                    cnt--;
                }
                if (map[i][j] == 2) {
                    v2.offer(new Pos(i, j));
                    visited[i][j] = 2;
                    cnt--;
                }
                if (map[i][j] == -1) {
                    cnt--;
                    visited[i][j] = 4;
                }
            }
        }

        spread(v1, v2, visited);

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 1) cnt1++;
                if (visited[i][j] == 2) cnt2++;
                if (visited[i][j] == 3) cnt3++;
            }
        }

        System.out.println(cnt1 + " " + cnt2 + " " + cnt3);
    }

    static void print(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    static void spread(Queue<Pos> v1, Queue<Pos> v2, int[][] visited) {
        int cnt = 1;
        int[][] timeMap = new int[N][M];
        while (!v1.isEmpty() || !v2.isEmpty()) {
//            System.out.println(cnt);
            int size = v1.size();
            for (int s = 0; s < size; s++) {
                Pos now = v1.poll();

                if (visited[now.r][now.c] == 3) continue;

                for (int d = 0; d < deltas.length; d++) {
                    int nr = now.r + deltas[d][0];
                    int nc = now.c + deltas[d][1];
                    if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0) {
                        if (visited[nr][nc] > 0) continue;
                        visited[nr][nc] = 1;
                        timeMap[nr][nc] = cnt;
                        v1.offer(new Pos(nr, nc));
                    }
                }
            }

//            print(visited);
            size = v2.size();
            for (int s = 0; s < size; s++) {
                Pos now = v2.poll();
                for (int d = 0; d < deltas.length; d++) {
                    int nr = now.r + deltas[d][0];
                    int nc = now.c + deltas[d][1];
                    if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0) {
                        if (visited[nr][nc] > 1) continue;
                        if (visited[nr][nc] == 0) {
                            visited[nr][nc] = 2;
                            v2.offer(new Pos(nr, nc));
                        } else if (visited[nr][nc] == 1 && timeMap[nr][nc] == cnt) {
                            visited[nr][nc] = 3;
                        }
                    }
                }
            }
//            print(visited);

            cnt++;
        }
    }
}