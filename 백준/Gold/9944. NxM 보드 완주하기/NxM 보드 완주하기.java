import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}}, totalCnt, minStep;
    static char[][] map;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        int caseCnt = 1;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            totalCnt = 0;
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == '.') totalCnt++;
                }
            }

            minStep = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == '.') {
                        visited = new int[N][M];
                        visited[i][j] = 1;
                        dfs(i, j, 1, 1);
                    }
                }
            }
            if (minStep == Integer.MAX_VALUE) minStep = -1;
            sb.append("Case ").append(caseCnt++).append(": ").append(minStep).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int i, int j, int step, int cnt) {
        if (step > minStep) return;
        if (cnt == totalCnt) {
            minStep = step-1;
            return;
        }
        for (int d = 0; d < deltas.length; d++) {
            int dist = getDist(i, j, d, step);
            if (dist == 0) continue;
//            System.out.println(dist);
//            setVisited(i, j, d, dist, step);
//            print();
            dfs(i+deltas[d][0]*dist, j+deltas[d][1]*dist, step+1, cnt+dist);
            setVisited(i, j, d, dist, 0);
        }
    }

    static void print() {
        for (int i = 0; i < visited.length; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
        System.out.println();
    }

    static void setVisited(int i, int j, int d, int dist, int step) {
        for (int k = 1; k <= dist; k++) {
            int nr = i + deltas[d][0] * k;
            int nc = j + deltas[d][1] * k;
            visited[nr][nc] = step;
        }
    }

    static int getDist(int i, int j, int d, int step) {
        int dist = 1;
        while (true) {
            int nr = i + deltas[d][0] * dist;
            int nc = j + deltas[d][1] * dist;
            if (0 > nr || nr >= N || 0 > nc || nc >= M
                    || map[nr][nc] == '*'
                    || visited[nr][nc] > 0) return dist-1;
            visited[nr][nc] = step;
            dist++;
        }
    }
}
