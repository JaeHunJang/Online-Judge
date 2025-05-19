import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, deltas[][] = {{0,0},{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1,1},{-1,1},{1,-1},{-1,-1}};
    static char map[][];
    static Queue<Pos> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 8;
        q = new ArrayDeque<>();

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            int j = 0;
            for (char ch : br.readLine().toCharArray()) {
                map[i][j++] = ch;
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        System.out.println(bfs());
    }

    static int bfs() {
        q.offer(new Pos(7, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            boolean[][] visited = new boolean[N][N];
//            System.out.println(size);
            for (int s = 0; s < size; s++) {
                Pos now = q.poll();

                if (now.r == 0 && now.c == 7) {
                    return 1;
                }

                for (int d = 0; d < deltas.length; d++) {
                    int nr = now.r + deltas[d][0];
                    int nc = now.c + deltas[d][1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (visited[nr][nc]) continue;
                    if (map[nr][nc] == '#') continue;

                    visited[nr][nc] = true;
                    q.offer(new Pos(nr, nc));
                }
            }
            downWall();
        }

        return 0;
    }

    static void downWall() {
        for (int i = N-1; i > 0; i--) {
            for (int j = 0; j < N; j++) {
                map[i][j] = map[i-1][j];
            }
        }
        for (int i = 0; i < N; i++) {
            map[0][i] = '.';
        }

        Queue<Pos> tmp = new ArrayDeque<>();
        for (Pos now : q) {
            if (map[now.r][now.c] == '.') {
                tmp.offer(now);
            }
        }
        q.clear();
        q.addAll(tmp);
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println("현재 사이즈" + q.size());
    }


    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}