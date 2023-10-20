import java.util.*;
class Solution {
    int answer = -1;
    
    public void adventure(int k, boolean[] visit, int[][] dungeons, int count){
        for(int i = 0; i < dungeons.length; i++){
            if(!visit[i] && dungeons[i][0] <= k){
                visit[i] = true;
                adventure(k - dungeons[i][1], visit, dungeons, count+1);
                visit[i] = false;
            }
        }
        
        answer = Math.max(answer, count);
    }
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visit = new boolean[dungeons.length];
        
        adventure(k, visit, dungeons, 0);
        
        return answer;
    }
}