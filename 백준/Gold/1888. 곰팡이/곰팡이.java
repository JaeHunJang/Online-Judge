import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, map[][], deltas[][] = {{1,0},{0,-1},{-1,0},{0,1}};
    static Map<Integer, Queue<int[]>> molds;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        molds = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            molds.put(i, new ArrayDeque<>());
        }

        for (int i = 0; i < N; i++) {
            int j = 0;
            for (char ch : br.readLine().toCharArray()) {
                map[i][j] = ch - '0';
                if (map[i][j] > 0) {
                    Queue<int[]> q = molds.get(map[i][j]);
                    q.add(new int[]{i, j});
                    molds.put(map[i][j], q);
                }
                j++;
            }
        }

        int t = 0;
        while (!isOne()) {
            t++;
            for (int k = 5; k >= 1; k--) {
                Queue<int[]> q = molds.get(k);
                Queue<int[]> next = new ArrayDeque<>();
                while (!q.isEmpty()) {
                    int[] now = q.poll();
                    int sr = Math.max(0, now[0] - k);
                    int er = Math.min(N-1, now[0] + k);
                    int sc = Math.max(0, now[1] - k);
                    int ec = Math.min(M-1, now[1] + k);

                    for (int i = sr; i <= er; i++) {
                        for (int j = sc; j <= ec; j++) {
                            if (map[i][j] >= k) continue;
                            map[i][j] = k;
                            next.offer(new int[]{i,j});
                        }
                    }
                }
                molds.put(k, next);
            }
//            for (int j = 0; j < N; j++) {
//                System.out.println(Arrays.toString(map[j]));
//            }
//            System.out.println();
        }
        System.out.println(t);
    }

    static boolean isOne() {
        int cnt = 0;
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && visited[i][j] == 0) {
                    cnt++;
                    bfs(i, j, visited, cnt);
                }
                if (cnt > 1) return false;
            }

        }

        return true;
    }

    static void bfs(int r, int c, int[][] visited, int m) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        visited[r][c] = m;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] d : deltas) {
                int nr = now[0] + d[0];
                int nc = now[1] + d[1];
                if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if (visited[nr][nc] > 0 || map[nr][nc] == 0) continue;
                    visited[nr][nc] = m;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}