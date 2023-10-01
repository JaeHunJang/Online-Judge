import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0; 
        
        Arrays.sort(citations);
        
        // for (int i = citations.length - 1 ; i > 0; i--){
        //     int cnt = 0;
        //     for(int j = 0; j < citations.length; j++ ){
        //         if(citations[j] > i) cnt++;
        //     }
        //     if (cnt <= i) {
        //         answer = i;
        //     }
        // }
        
        int cnt = citations.length;
        for (int i = 0 ; i < citations.length; i++){
            if (citations[i] >= cnt) {
                answer = cnt;
            } else cnt--;
        }
        
        return answer;
    }
}