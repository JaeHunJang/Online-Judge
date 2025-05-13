import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, dist, cnt, map[][], visited[][], deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static Map<Integer, List<Pos>> lands;
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
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(map[i]));
        }

//        System.out.println();
        lands = new HashMap<>();
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
//                    System.out.println();
                    cnt++;
                    lands.put(cnt, bfs(i, j, cnt));
                }
            }
        }
//        System.out.println(lands);

        dist = N * N;
        int[][] tmp = new int[N][N];
        for (int k : lands.keySet()) {
            for (Pos p : lands.get(k)) {
//                tmp[p.r][p.c] = k;
                for (int k2 : lands.keySet()) {
                    if (k == k2) continue;
                    for (Pos p2 : lands.get(k2)) {
//                        tmp[p2.r][p2.c] = k;
//                        System.out.println(p + " : " + p2 + " = " + getDist(p.r, p.c, p2.r, p2.c));
                        dist = Math.min(dist, getDist(p.r, p.c, p2.r, p2.c));
                    }
                }
            }
        }
//        System.out.println("테두리만");
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(tmp[i]));
//        }

        System.out.println(dist-1);
    }

    static List<Pos> bfs(int r, int c, int cnt) {
        List<Pos> list = new ArrayList<>();
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(r, c));
        visited[r][c] = cnt;
        if (isBorder(r, c)) {
            list.add(new Pos(r, c));
        }

        while (!q.isEmpty()) {
            Pos now = q.poll();

            for (int[] d : deltas) {
                int nr = now.r + d[0];
                int nc = now.c + d[1];
                if (!isIn(nr, nc) || visited[nr][nc] > 0 || map[nr][nc] == 0) continue;
                visited[nr][nc] = cnt;
                if (isBorder(nr, nc)) {
                    list.add(new Pos(nr, nc));
                }
                q.offer(new Pos(nr, nc));
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(visited[i]));
//        }

        return list;
    }

    static boolean isBorder(int r, int c) {
        for (int[] d : deltas) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (!isIn(nr, nc) || map[nr][nc] == 0) return true;
        }
        return false;
    }

    static int getDist(int sr, int sc, int er, int ec) {
        return Math.abs(er - sr) + Math.abs(ec - sc);
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}