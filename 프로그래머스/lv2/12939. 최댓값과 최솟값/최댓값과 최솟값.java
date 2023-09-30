import java.util.*;
class Solution {
    public String solution(String s) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(String ch : s.split(" ")){
            max = Math.max(max, Integer.parseInt(ch));
            min = Math.min(min, Integer.parseInt(ch));
        }
        
        return min + " " + max;
    }
}