import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int dp[] = new int[y*3+1];
        Arrays.fill(dp, 1000000);
        dp[x] = 0;
        dp[x+n] = 1;
        dp[x*2] = 1;
        dp[x*3] = 1;
        for (int i = x+1; i < dp.length; ++i) {
            if (i-n > 0) {
                dp[i] = Math.min(dp[i-n] + 1, dp[i]);
            }
            if (i/2 > 0 && i%2 == 0) {
                dp[i] = Math.min(dp[i/2] + 1, dp[i]);
            }
            if (i/3 > 0 && i%3 == 0) {
                dp[i] = Math.min(dp[i/3] + 1, dp[i]);
            }
            
        }
        int answer = dp[y] == 1000000 ? -1 : dp[y];
        return answer;
    }
}