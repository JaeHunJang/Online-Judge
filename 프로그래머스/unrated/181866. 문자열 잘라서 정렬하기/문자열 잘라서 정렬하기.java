import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] temp = myString.split("x");
        Arrays.sort(temp);
        
        int i = 0;
        for(String s : temp){
            if(s.equals("")) i++;
            else break;
        }
        
        return Arrays.copyOfRange(temp, i, temp.length);
    }
}