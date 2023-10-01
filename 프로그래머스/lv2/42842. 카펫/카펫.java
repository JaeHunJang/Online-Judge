import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i = sum / 2; i > 2; i--){
            if(sum % i == 0 && ((i-2) * (sum / i - 2)) == yellow) {
                answer[0] = i;
                answer[1] = sum / i;
                break;
            }
        }
        
        return answer;
    }
}