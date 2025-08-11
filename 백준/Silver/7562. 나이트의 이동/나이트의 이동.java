import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int l = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            sb.append(simulate(sr,sc,er,ec,l)).append("\n");
        }
        System.out.println(sb);
    }

    static int simulate(int sr, int sc, int er, int ec, int l) {
        int[][] deltas = {{-2,-1},{-1,-2},{-2,1},{-1,2},{1,2},{2,1},{1,-2},{2,-1}};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sr, sc});
        int[][] visited = new int[l][l];
        int time = 1;
        visited[sr][sc] = time++;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] now = q.poll();

                if (visited[er][ec] != 0) return visited[er][ec]-1;

                for (int[] d : deltas) {
                    int nr = now[0] + d[0];
                    int nc = now[1] + d[1];

                    if (nr < 0 || nr >= l || nc < 0 || nc >= l || visited[nr][nc] > 0) continue;
                    visited[nr][nc] = time;
                    q.offer(new int[] {nr, nc});
                }
            }
            time++;
        }

        return time;
    }
}
