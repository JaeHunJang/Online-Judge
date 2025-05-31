import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, map[][], deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static Pos start, end;
    static class Pos {
        int r, c, wandCnt;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
            wandCnt = 0;
        }

        public Pos(int r, int c, int wandCnt) {
            this.r = r;
            this.c = c;
            this.wandCnt = wandCnt;
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
        start = new Pos(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        st = new StringTokenizer(br.readLine());
        end = new Pos(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }


    static int bfs() {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(start);
        boolean visited[][][] = new boolean[2][N][M];
        visited[start.wandCnt][start.r][start.c] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
//            System.out.println(q);
            for (int s = 0; s < size; s++) {
                Pos now = q.poll();

                if (now.r == end.r && now.c == end.c) {
                    return cnt;
                }

                for (int[] d : deltas) {
                    int nr = now.r + d[0];
                    int nc = now.c + d[1];
                    if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                        if (visited[now.wandCnt][nr][nc]) continue;
                        visited[now.wandCnt][nr][nc] = true;
                        if (map[nr][nc] == 1 && now.wandCnt == 0) {
                            q.offer(new Pos(nr, nc, now.wandCnt+1));
                        } else if (map[nr][nc] == 0) {
                            q.offer(new Pos(nr, nc, now.wandCnt));
                        }
                    }
                }
            }
            cnt++;
        }

        return -1;
    }
}