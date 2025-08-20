import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, map[][], visited[][], deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new int[M][N];

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (map[0][i] == 0) {
                q.offer(new int[] {0, i});
                visited[0][i] = cnt;
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
                    if (nr < 0 || nr >= M || nc < 0 || nc >= N || map[nr][nc] == 1 || visited[nr][nc] > 0) continue;
                    visited[nr][nc] = cnt;
                    q.offer(new int[] {nr, nc});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (visited[M-1][i] > 0) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
