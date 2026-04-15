import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] dp = new boolean[n+1][n+1];
        
        for (int i = 0; i < results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            dp[a][b] = true;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (dp[i][k] && dp[k][j]) dp[i][j] = true;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int wcnt = 0, lcnt = 0;
            for (int j = 1; j <= n; j++) {
                if (dp[i][j]) wcnt++;
                if (dp[j][i]) lcnt++;
            }
            if (wcnt + lcnt == n-1) answer++;
        }
        
        return answer;
    }
}