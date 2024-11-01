import java.util.*;

class Solution {
     public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] dp = new int[n+1][n+1];
                  
         for (int[] result : results) {
             dp[result[0]][result[1]] = 1;
             dp[result[1]][result[0]] = -1;
         }
         
         for (int k = 0; k <= n; k++) {
             for (int i = 1; i <= n; i++) {
                 for (int j=0; j <= n; j++) {
                     if (dp[i][k] == 1 && dp[k][j] == 1) dp[i][j] = 1;
                     if (dp[i][k] == -1 && dp[k][j] == -1) dp[i][j] = -1;
                 }
             }
         }
         
         for (int i = 1; i <= n; i++) {
             int cnt = 0;
             for (int j=1; j <= n; j++) {
                 if (i != j && dp[i][j] != 0) cnt++;
             }
             if (cnt == n-1) answer++;
         }
         

        return answer;
    }
}
