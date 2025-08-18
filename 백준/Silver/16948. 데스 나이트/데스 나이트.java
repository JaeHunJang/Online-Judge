import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, sr, sc, er, ec, deltas[][] = {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
    static int visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        er = Integer.parseInt(st.nextToken());
        ec = Integer.parseInt(st.nextToken());

        System.out.println(find());
    }

    static int find() {
        Queue<int[]> q = new ArrayDeque<>();
        visited = new int[n][n];
        int cnt = 1;
        q.offer(new int[] {sr, sc});
        visited[sr][sc] = cnt;

        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            while (size-- > 0) {
                int[] now = q.poll();

                if (visited[er][ec] > 0) return visited[er][ec]-1;

                for (int[] d : deltas) {
                    int nr = now[0] + d[0];
                    int nc = now[1] + d[1];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc] > 0) continue;
                    visited[nr][nc] = cnt;
                    q.offer(new int[] {nr, nc});
                }
            }
        }

        return -1;
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
        System.out.println();
    }
}
