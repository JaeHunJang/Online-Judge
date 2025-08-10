import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int map[][] = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    map[j][k] = i+1;
                }
            }
        }


        boolean visited[][] = new boolean[M][N];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    q.offer(bfs(i, j, map, visited));
                }
            }
        }
        System.out.println(q.size());
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }

    static int bfs(int r, int c, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] d : deltas) {
                int nr = now[0] + d[0];
                int nc = now[1] + d[1];
                if (nr < 0 || nr >= visited.length || nc < 0 || nc >= visited[0].length || map[nr][nc] > 0 || visited[nr][nc] ) continue;
                visited[nr][nc] = true;
                cnt++;
                q.offer(new int[] {nr, nc});
            }
        }

        return cnt;
    }
}
