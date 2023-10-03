import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i+=2) 
            list.add(i);
        
        int[] answer = new int[list.size()];
        int i = 0;
        for(int num : list)
            answer[i++] = num;
        
        return answer;
    }
}