import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] temp = s.split("");
        Arrays.sort(temp);
        
        for(String ch : temp){
            if(s.length() - s.replaceAll(ch, "").length() == 1)
                if(!answer.contains(ch)) answer += ch;
        }
        
        return answer;
    }
}