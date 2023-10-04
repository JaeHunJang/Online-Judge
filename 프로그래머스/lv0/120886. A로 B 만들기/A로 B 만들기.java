import java.util.*;
class Solution {
    public int solution(String before, String after) {
        
        String[] tempA = after.split("");
        String[] tempB = before.split("");
        
        Arrays.sort(tempA);
        Arrays.sort(tempB);
        
        return Arrays.equals(tempA, tempB) ? 1 : 0;
    }
}