import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        Arrays.fill(answer, 1);
        
        for(int i = 0; i < answer.length; i++){
            double avg = (score[i][0] + score[i][1]) / 2.0;
            for(int j = 0; j < answer.length; j++){
                double avg2 = (score[j][0] + score[j][1]) / 2.0;
                if(avg2 > avg) answer[i]++;
            }
        }
        
        return answer;
    }
}