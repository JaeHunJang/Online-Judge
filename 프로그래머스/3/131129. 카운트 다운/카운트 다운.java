import java.util.*;
class Solution {
    public int[] solution(int target) {
        int[][] dp = new int[2][target+61];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;
        dp[1][0] = 0;
        for (int i = 1; i <= 20; ++i) {
            dp[0][i] = 1;
            dp[1][i] = 1;
            //System.out.println(Arrays.toString(new int[] {dp[0][i], dp[1][i]}));
        }
        
        for (int i = 1; i <= target; ++i) {
            //System.out.println("idx: " + i);
            for (int j = 1; j <= 20; ++j) {
                //System.out.println("score: " + j);
                //System.out.println("0: " + Arrays.toString(new int[] {dp[0][i], dp[1][i]}));
                if (i - j >= 0) {
                    if (dp[0][i] > dp[0][i-j] + 1) {
                        dp[0][i] = dp[0][i-j] + 1;
                        dp[1][i] = dp[1][i-j] + 1;
                    } else if (dp[0][i] == dp[0][i-j] + 1 && dp[1][i] < dp[1][i-j] + 1) {
                        dp[1][i] = dp[1][i-j] + 1;
                    }
                }
                //System.out.println("1: " + Arrays.toString(new int[] {dp[0][i], dp[1][i]}));
                if (i - j * 2 >= 0) {
                    if (dp[0][i] > dp[0][i-j*2] + 1) {
                        dp[0][i] = dp[0][i-j*2] + 1;
                        dp[1][i] = dp[1][i-j*2];
                    } else if (dp[0][i] == dp[0][i-j*2] + 1 && dp[1][i] < dp[1][i-j*2]) {
                        dp[1][i] = dp[1][i-j*2];
                    }
                }
                //System.out.println("2: " + Arrays.toString(new int[] {dp[0][i], dp[1][i]}));
                
                if (i - j * 3 >= 0) {
                    if (dp[0][i] > dp[0][i-j*3] + 1) {
                        dp[0][i] = dp[0][i-j*3] + 1;
                        dp[1][i] = dp[1][i-j*3];
                    } else if (dp[0][i] == dp[0][i-j*3] + 1 && dp[1][i] < dp[1][i-j*3]) {
                        dp[1][i] = dp[1][i-j*3];
                    }
                }
                //System.out.println("3: " + Arrays.toString(new int[] {dp[0][i], dp[1][i]}));
                
            }
            
            if (i - 50 >= 0) {
                if (dp[0][i] > dp[0][i-50] + 1) {
                    dp[0][i] = dp[0][i-50] + 1;
                    dp[1][i] = dp[1][i-50] + 1;
                } else if (dp[0][i] == dp[0][i-50] + 1 && dp[1][i] < dp[1][i-50] + 1) {
                    dp[1][i] = dp[1][i-50] + 1;
                }
            }
            //System.out.println("50: " + Arrays.toString(new int[] {dp[0][i], dp[1][i]}));
        }
        
        return new int[] {dp[0][target],dp[1][target]};
    }
}