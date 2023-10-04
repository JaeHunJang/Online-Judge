import java.util.*;
class Solution {
    public int[] solution(String myString) {
        
        myString = myString.endsWith("x") ? myString + " " : myString;
        
        int[] answer = new int[myString.split("x").length];
        
        int i = 0;
        for(String s : myString.split("x"))
            answer[i++] = s.length();
        
        if (myString.endsWith(" ")) answer[i-1]--;
        
        return answer;
    }
}