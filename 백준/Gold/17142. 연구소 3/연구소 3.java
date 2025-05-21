import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, map[][], deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}}, minTime;
    static List<Virus> viruses;
    static boolean[] selected;
    static class Virus {
        int r, c;

        public Virus(int r, int c) {
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
        viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    viruses.add(new Virus(i, j));
                }
            }
        }
        selected = new boolean[viruses.size()];

        minTime = Integer.MAX_VALUE;
        perm(0, 0);

        if (minTime == Integer.MAX_VALUE) {
            minTime = -1;
        }
        System.out.println(minTime);
    }

    static int bfs() {
        Queue<Virus> q = new ArrayDeque<>();
        int[][] visited = new int[N][N];
        int time = 1;

        for (int i = 0; i < selected.length; i++) {
            Virus v = viruses.get(i);
            visited[v.r][v.c] = time;
            if (selected[i]) {
                q.offer(new Virus(v.r, v.c));
            }
        }

        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Virus now = q.poll();

                for (int d = 0; d < deltas.length; d++) {
                    int nr = deltas[d][0] + now.r;
                    int nc = deltas[d][1] + now.c;
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (map[nr][nc] == 1) continue;
                    if (visited[nr][nc] == 0 || (map[nr][nc] == 2 && visited[nr][nc] == 1)) {
                        visited[nr][nc] = time;
                        q.offer(new Virus(nr, nc));
                    }
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(visited[i]));
//        }

        time = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    if (visited[i][j] == 0) return -1;
                    time = Math.max(time, visited[i][j]-1);
                }
            }
        }
        return time;
    }

    static void perm(int cnt, int start) {
        if (cnt == M) {
//            System.out.println(Arrays.toString(selected));
            int time = bfs();
            if (time >= 0) minTime = Math.min(minTime, time);
//            System.out.println(minTime);
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            if (selected[i]) continue;
            selected[i] = true;
            perm(cnt+1, i+1);
            selected[i] = false;
        }
    }
}