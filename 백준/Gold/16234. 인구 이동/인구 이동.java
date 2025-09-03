import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R, map[][], deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int visited[][];
    static Map<Integer, Integer> union;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        union = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int date = 0;
        while (true) {
            int cnt = 1;
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        fillMap(i, j, cnt++);
                    }
                }
            }

            if (union.isEmpty()) break;
            date++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0 || !union.containsKey(visited[i][j])) continue;
                    map[i][j] = union.get(visited[i][j]);
                }
//                System.out.println(Arrays.toString(map[i]));
            }
//            System.out.println();
            union.clear();
        }
        System.out.println(date);
    }

    static boolean fillMap(int r, int c, int flag) {
//        System.out.println(flag);
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        int cnt = 1;
        int sum = map[r][c];
        visited[r][c] = flag;
        while (!q.isEmpty()) {
            int size = q.size();
//            System.out.println("size : " + size);
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int d = 0; d < deltas.length; d++) {
                    int nr = cur[0] + deltas[d][0];
                    int nc = cur[1] + deltas[d][1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] > 0) continue;
                    int gap = Math.abs(map[nr][nc] - map[cur[0]][cur[1]]);
                    if (L <= gap && gap <= R) {
                        visited[nr][nc] = flag;
                        cnt++;
                        sum += map[nr][nc];
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
        }

        if (cnt > 1) {
            union.put(flag, sum / cnt);
        }
//        System.out.println(union);
//        System.out.println(cnt);

        return cnt > 1;
    }
}
