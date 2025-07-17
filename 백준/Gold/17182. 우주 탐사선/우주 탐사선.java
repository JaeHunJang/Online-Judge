import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, K, map[][], minTime = Integer.MAX_VALUE;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        visited[K] = true;
        dfs(K, 1, 0);

        System.out.println(minTime);
    }

    static void dfs(int cur, int cnt, int total) {
        if (cnt == N) {
            minTime = Math.min(minTime, total);
            return;
        }

        for (int next = 0; next < N; next++) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, cnt + 1, total + map[cur][next]);
                visited[next] = false;
            }
        }
    }
}