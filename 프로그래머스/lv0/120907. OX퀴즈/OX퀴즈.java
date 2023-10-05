import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        int i = 0;
        for(String q : quiz){
            String[] temp = q.split(" ");
            
            String[] num;
            if(temp[1].contains("+")){
                if(Integer.parseInt(temp[0]) + Integer.parseInt(temp[2]) == Integer.parseInt(temp[4]))
                    answer[i++] = "O";
                else answer[i++] = "X";
           } else {
                if(Integer.parseInt(temp[0]) - Integer.parseInt(temp[2]) == Integer.parseInt(temp[4]))
                    answer[i++] = "O";
                else answer[i++] = "X";
            }
        }
        
        return answer;
    }
}