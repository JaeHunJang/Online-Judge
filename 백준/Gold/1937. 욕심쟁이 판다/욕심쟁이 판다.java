import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, map[][], dp[][], deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxDist = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0) dp[i][j] = 1;
//                System.out.println("시작: " + i + ", " + j);
                dfs(i, j);
//                for (int k = 0; k < N; k++) {
//                    System.out.println(Arrays.toString(dp[k]));
//                }
                maxDist = Math.max(maxDist, dp[i][j]);
            }
        }

        System.out.println(maxDist);
    }

    static int dfs(int r, int c) {
//        System.out.println(r + ", " + c + " = " + dp[r][c]);
        for (int[] d : deltas) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] > map[r][c]) {
                if (dp[nr][nc] == 0) {
                    dp[nr][nc] = Math.max(dp[nr][nc], dfs(nr, nc));
                }
                dp[r][c] = Math.max(dp[r][c], dp[nr][nc] + 1);
            }
        }

        if (dp[r][c] == 0) {
            dp[r][c] = 1;
        }
        return dp[r][c];
    }
}
