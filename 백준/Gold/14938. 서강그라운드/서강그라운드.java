import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, R, items[], dp[][];
    static List<Edge> list[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        items = new int[N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            Arrays.fill(dp[i], 100 * 100 * 15 + 1);
            dp[i][i] = 0;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
//            list[a].add(new Edge(b, c));
//            list[b].add(new Edge(a, c));
            dp[a][b] = c;
            dp[b][a] = c;
        }

        bfs();

        int maxItem = 0;
        for (int k = 1; k <= N; k++) {
            int item = 0;
            for (int j = 1; j <= N; j++) {
                if (dp[k][j] <= M)
                    item += items[j];
            }
            maxItem = Math.max(maxItem, item);
        }

        System.out.println(maxItem);
    }

    static void bfs() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        for (int i = 0; i <= N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
        }
    }

    static class Edge {
        int to, dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}
