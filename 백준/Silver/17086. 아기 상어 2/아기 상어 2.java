import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, map[][], deltas[][] = {{0,1},{-1,0},{0,-1},{1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
    static int visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(find());
    }

    static int find() {
        Queue<int[]> q = new ArrayDeque<>();
        visited = new int[n][m];
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    q.offer(new int[] {i, j});
                    visited[i][j] = cnt;
                }
            }
        }

        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            while (size-- > 0) {
                int[] now = q.poll();

                for (int[] d : deltas) {
                    int nr = now[0] + d[0];
                    int nc = now[1] + d[1];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] == 1 || visited[nr][nc] > 0) continue;
                    visited[nr][nc] = cnt;
                    q.offer(new int[] {nr, nc});
                }
            }
        }

        int distance = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance = Math.max(distance, visited[i][j]-1);
            }
        }

        return distance;
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
        System.out.println();
    }
}
