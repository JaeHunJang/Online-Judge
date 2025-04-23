import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, nums[], result;
    static long count, dp[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        dp = new long[N][21];
        dp[0][nums[0]] = 1;
        for (int i = 1; i < N - 1; i++) {
            for (int sum = 0; sum <= 20; sum++) {
                if (dp[i - 1][sum] > 0) {
                    int plus = sum + nums[i];
                    int minus = sum - nums[i];

                    if (plus <= 20) {
                        dp[i][plus] += dp[i - 1][sum];
                    }
                    if (minus >= 0) {
                        dp[i][minus] += dp[i - 1][sum];
                    }
                }
            }
        }

        System.out.println(dp[N - 2][nums[N-1]]); // 마지막 숫자와 누적합이 같아야 함
    }
}
