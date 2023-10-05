import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {

        Arrays.sort(spell);
        for(String s : dic){
            String[] temp = s.split("");
            Arrays.sort(temp);
            if(Arrays.equals(spell, temp))
                return 1;
        }
        
        return 2;
    }
}