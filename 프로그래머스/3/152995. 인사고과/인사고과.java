import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        for (int i = 1; i < scores.length; i++) {
            if (scores[0][0] + scores[0][1] < scores[i][0] + scores[i][1]) {
                if (isCheck(scores[i], scores)) {
                    answer++;
                }
            }
        }
        
        for (int i = 1; i < scores.length; i++) {
            if (scores[0][0] < scores[i][0] && scores[0][1] < scores[i][1]) return -1;
        }
        
        return answer;
    }
    
    boolean isCheck(int[] now, int[][] scores) {
        for (int i = 0; i < scores.length; ++i) {
            if (now[0] < scores[i][0] && now[1] < scores[i][1]) {
                return false;
            }
        }
        return true;
    }
}