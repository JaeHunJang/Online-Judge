import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, map[][], visited[][], deltas[][] = {{1,0},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[n-1][m-1] == 0) {
            System.out.println("No");
            return;
        }

        bfs();

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(visited[i]));
//        }
    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        int cnt = 1;
        visited[0][0] = cnt;
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            while (size-- > 0) {
                int[] now = q.poll();

                if (visited[n-1][m-1] > 0) {
                    System.out.println("Yes");
                    return;
                }

                for (int[] d : deltas) {
                    int nr = now[0] + d[0];
                    int nc = now[1] + d[1];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] == 0 || visited[nr][nc] > 0) continue;
                    visited[nr][nc] = cnt;
                    q.offer(new int[] {nr, nc});
                }
            }
        }

        System.out.println("No");
    }
}
