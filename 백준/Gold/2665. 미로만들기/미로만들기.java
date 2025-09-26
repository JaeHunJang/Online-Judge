import java.io.*;
import java.util.*;

public class Main {
    static int N, map[][];
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        q.offer(new int[] {0, 0, 0});
        int visited[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[0][0] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], cnt = cur[2];

            for (int[] d : deltas) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                int nextCnt = cnt + (map[nr][nc] == 0 ? 1 : 0);

                if (visited[nr][nc] > nextCnt) {
                    visited[nr][nc] = nextCnt;
                    q.offer(new int[]{nr, nc, nextCnt});
                }
            }

//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(visited[i]));
//            }
//            System.out.println();
        }

        System.out.println(visited[N-1][N-1]);
    }
}
