import java.util.*;
import java.math.*;

class Solution {
    public BigInteger solution(int balls, int share) {
        BigInteger answer;
        
        BigInteger[] dp = new BigInteger[balls];
        dp[0] = new BigInteger(1+"");
        
        if(share == 1) return new BigInteger(balls+"");
        else if(balls == share) return dp[0];
        
        for(int i = 1; i < balls; i++){
            dp[i] = dp[i-1].multiply(new BigInteger((i + 1) + ""));
        }
        
        answer = dp[balls-1].divide(dp[(balls-share)-1].multiply(dp[share-1]));
        
        return answer;
    }
}