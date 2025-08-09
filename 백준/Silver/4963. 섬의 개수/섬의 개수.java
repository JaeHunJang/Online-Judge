import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int w, h, map[][], deltas[][] = {{0,1},{-1,0},{0,-1},{1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        find(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void find(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] d : deltas) {
                int nr = now[0] + d[0];
                int nc = now[1] + d[1];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc] == 0) continue;
                map[nr][nc] = 0;
                q.offer(new int[] {nr, nc});
            }
        }
    }
}
