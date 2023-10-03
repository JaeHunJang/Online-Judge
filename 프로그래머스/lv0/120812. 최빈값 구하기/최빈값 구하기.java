import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int maxCount = 0;
        int count = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int n : array){
            map.put(n, map.getOrDefault(n, 0) + 1);
            count = map.get(n);
            
            if(count > maxCount){
                maxCount = count;
                answer = n;
            } else if (count == maxCount){
                answer = -1;
            }
        }
        
        return answer;
    }
}