import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        if (sticker.length == 1) return sticker[0];
        else if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        
        int[] dp = new int[sticker.length-1];
        
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        for (int i = 2; i < dp.length; ++i) {
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }
        
        int[] dp2 = new int[sticker.length];
        
        dp2[1] = sticker[1];
        for (int i = 2; i < dp2.length; ++i) {
            dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);
        }
        
        return Math.max(dp[dp.length-1], dp2[dp2.length-1]);
    }
}