import java.io.*;
import java.util.*;

public class Main {
    static int V, E, dp[][];
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static final int INF = 10000 * 400 + 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dp = new int[V+1][V+1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                dp[i][j] = INF;
                if (i == j) dp[i][j] = 0;
            }

        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[a][b] = c;
        }

        for (int k = 1; k <= V; k++) { // 경유지
            for (int i = 1; i <= V; i++) { // 출발지
                for (int j = 1; j <= V; j++) { // 도착지
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int minDist = INF;
        for (int i = 1; i <= V; i++) { // 출발지
            for (int j = 1; j <= V; j++) { // 도착지
                if (i == j) continue;
                minDist = Math.min(minDist, dp[i][j] + dp[j][i]);
            }
        }

        System.out.println(minDist == INF ? -1 : minDist);
    }
}
