import java.util.*;

class Solution {
    int dp[][];
    public int solution(int[][] board, int[][] skill) {
        dp = new int[board.length+1][board[0].length+1];
        for (int i = 0; i < skill.length; ++i) {
            calc(skill[i]);
        }
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[i][j] += dp[i][j-1];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[j][i] += dp[j-1][i];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] + dp[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
    
    void calc(int[] skill) {
        int attack = (skill[0] == 1 ? -1 : 1) * skill[5];
        dp[skill[3]+1][skill[4]+1] += attack;
        dp[skill[1]][skill[4]+1] -= attack;
        dp[skill[3]+1][skill[2]] -= attack;
        dp[skill[1]][skill[2]] += attack;
    }
}