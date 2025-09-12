import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, minTime, totalCnt, selected[], map[][], deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    static List<Pos> virusPos;
    static boolean visited[];
    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virusPos = new ArrayList<>();
        totalCnt = N * N;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virusPos.add(new Pos(i, j));
                if (map[i][j] == 1) totalCnt--;
            }
        }
        selected = new int[M];
        visited = new boolean[virusPos.size()];
        minTime = Integer.MAX_VALUE;
        perm(0, 0);
        if(minTime == Integer.MAX_VALUE) minTime = -1;
        System.out.println(minTime);
    }

    static void perm(int cnt, int start) {
        if (cnt == M) {
//            System.out.println(Arrays.toString(selected));
            minTime = Math.min(minTime, bfs());
//            System.out.println(minTime);
            return;
        }

        for (int i = start; i < virusPos.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            selected[cnt] = i;
            perm(cnt+1, i+1);
            visited[i] = false;
            selected[cnt] = 0;
        }
    }

    static int bfs() {
        Queue<Pos> q = new ArrayDeque<>();
        int[][] visited = new int[N][N];
        int time = 1;
        int cnt = 0;
        for (int p : selected) {
            Pos cur = virusPos.get(p);
            q.offer(cur);
            visited[cur.r][cur.c] = time;
            cnt++;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            while (size-- > 0) {
                Pos cur = q.poll();

                for (int d = 0; d < deltas.length; d++) {
                    int nr = cur.r + deltas[d][0];
                    int nc = cur.c + deltas[d][1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] > 0 || map[nr][nc] == 1) continue;
                    visited[nr][nc] = time;
                    cnt++;
                    q.offer(new Pos(nr, nc));
                }
            }
        }

        if (cnt != totalCnt) return Integer.MAX_VALUE;

        return time-2;
    }
}
