import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        
        for(int i = 0; left <= right; i++, left++){
            int x = (int)(left / n + 1);
            int y = (int)(left % n + 1);
            answer[i] = (x > y ? x : y);
        }
        
        return answer;
    }
}