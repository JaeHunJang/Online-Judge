import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, A[][];
    static int[][] deltas = {{0,0},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    static List<Pos> cloud;
    static class Pos {
        int r, c;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloud = new ArrayList<>();
        cloud.add(new Pos(N,1));
        cloud.add(new Pos(N,2));
        cloud.add(new Pos(N-1,1));
        cloud.add(new Pos(N-1,2));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            moveCloud(d, s);
            raining();
            copyWater();
            makeCloud();
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum += A[i][j];
            }
        }

        System.out.println(sum);
    }

    static void makeCloud() {
        boolean[][] visited = new boolean[N+1][N+1];
        for (Pos c : cloud) {
            visited[c.r][c.c] = true;
        }

        cloud.clear();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (A[i][j] >= 2 && !visited[i][j]) {
                    A[i][j] -= 2;
                    cloud.add(new Pos(i, j));
                }
            }
        }
    }

    static void copyWater() {
        for (Pos c : cloud) {
            int cnt = 0;
            for (int d = 2; d < deltas.length; d+=2) {
                int nr = c.r + deltas[d][0];
                int nc = c.c + deltas[d][1];
                if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
                if (A[nr][nc] > 0) cnt++;
            }
            A[c.r][c.c] += cnt;
        }
    }

    static void raining() {
        for (Pos c : cloud) {
            A[c.r][c.c]++;
        }
    }

    static void moveCloud(int d, int s) {
        List<Pos> movedCloud = new ArrayList<>();
        for(Pos c : cloud) {
            int nr = c.r + (deltas[d][0] * (s%N));
            int nc = c.c + (deltas[d][1] * (s%N));
            if (nr > N) {
                nr = nr % N;
            }
            if (nc > N) {
                nc = nc % N;
            }
            if (nr < 1) {
                nr = nr + N;
            }
            if (nc < 1) {
                nc = nc + N;
            }
            movedCloud.add(new Pos(nr, nc));
        }
        cloud.clear();
        cloud.addAll(movedCloud);
    }
}
