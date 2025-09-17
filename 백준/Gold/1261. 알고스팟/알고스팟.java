import java.io.*;
import java.util.*;

public class Main {
    static int N, M, map[][], deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));;
        q.offer(new int[]{0,0,map[0][0]});

        int[][] dist = new int[M][N];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = map[0][0];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], w = cur[2];

            if (r == M-1 && c == N-1) {
                System.out.println(w);
                return;
            }

            if (w > dist[r][c]) continue;

            for (int[] d : deltas) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if (dist[nr][nc] > w + map[nr][nc]) {
                    dist[nr][nc] = w + map[nr][nc];
                    q.offer(new int[]{nr, nc, dist[nr][nc]});
                }
            }
        }
    }
}
