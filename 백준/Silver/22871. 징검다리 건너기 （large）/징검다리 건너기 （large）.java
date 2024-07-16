import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 징검다리 건너기 (large)
public class Main {
    static int N;
    static long stones[], dp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stones = new long[N+1];
        dp = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, Long.MAX_VALUE);

        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                long min = power(j, i);
                min = Math.max(min, dp[j]);
                dp[i] = Math.min(dp[i], min);
            }
        }

        System.out.println(dp[N]);

    }

    static long power(int i, int j) {
        return (j - i) * (1 + Math.abs(stones[i] - stones[j]));
    }
}