import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, sr, sc, map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        fillMap();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(map[x][y]-1).append("\n");
        }

        System.out.println(sb);
    }

    static void fillMap() {
        int[][] deltas = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1,},{2,1}};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sr, sc});
        int cnt = 1;
        map[sr][sc] = cnt++;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int d = 0; d < deltas.length; d++) {
                    int nr = cur[0] + deltas[d][0];
                    int nc = cur[1] + deltas[d][1];

                    if (nr < 1 || nr > N || nc < 1 || nc > N || map[nr][nc] > 0) continue;
                    map[nr][nc] = cnt;
                    q.offer(new int[] {nr, nc});
                }
            }
            cnt++;
        }
    }
}
