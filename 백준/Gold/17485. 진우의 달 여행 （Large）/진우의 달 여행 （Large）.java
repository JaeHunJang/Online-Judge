import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 진우의 달 여행 (Large) / 80분
public class Main {
    static int N, M, map[][], deltas[] = {-1, 0, 1}, min, dp[][][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[3][N][M];

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int d = 0; d < 3; d++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i == 0) dp[d][i][j] = map[i][j];
                    else dp[d][i][j] = 1000000;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 3; d++) {
                    if (j != 0) dp[0][i][j] = Math.min(dp[1][i - 1][j - 1], dp[2][i - 1][j - 1]) + map[i][j];
                    dp[1][i][j] = Math.min(dp[0][i - 1][j], dp[2][i - 1][j]) + map[i][j];
                    if (j != M - 1) dp[2][i][j] = Math.min(dp[0][i - 1][j + 1], dp[1][i - 1][j + 1]) + map[i][j];
                }
            }
        }

        min = Integer.MAX_VALUE;
        for (int d = 0; d < 3; d++) {
            for (int i = 0; i < M; i++) {
                min = Math.min(min, dp[d][N - 1][i]);
            }
        }

        System.out.println(min);
    }
}