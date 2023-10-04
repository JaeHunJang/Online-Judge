import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[my_string.replaceAll("[a-z]","").length()];
        int i = 0;
        for(String s : my_string.replaceAll("[a-z]","").split(""))
            answer[i++] = Integer.parseInt(s);
        
        Arrays.sort(answer);
        return answer;
    }
}