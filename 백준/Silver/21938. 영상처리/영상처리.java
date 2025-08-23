import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, map[][][], newScreen[][], T, deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[3][N][M];
        newScreen = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int pixel = (map[0][i][j] + map[1][i][j] + map[2][i][j]) / 3;
                if (pixel >= T) newScreen[i][j] = 255;
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newScreen[i][j] > 0) {
                    find(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static void find(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] now = q.poll();

                for (int[] d : deltas) {
                    int nr = now[0] + d[0];
                    int nc = now[1] + d[1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || newScreen[nr][nc] == 0) continue;
                    newScreen[nr][nc] = 0;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }
}
