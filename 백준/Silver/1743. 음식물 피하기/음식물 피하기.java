import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k, map[][], deltas[][] = {{0,1},{-1,0},{0,-1},{1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1) {
                    max = Math.max(max, find(i, j));
                }
            }
        }

        System.out.println(max);
    }

    static int find(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        map[r][c] = 0;

        int cnt = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] d : deltas) {
                int nr = now[0] + d[0];
                int nc = now[1] + d[1];

                if (nr < 1 || nr > n || nc < 1 || nc > m || map[nr][nc] == 0) continue;
                map[nr][nc] = 0;
                cnt++;
                q.offer(new int[] {nr, nc});
            }
        }
        return cnt;
    }
}
