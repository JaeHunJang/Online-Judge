import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        List<String> list = new ArrayList();
        
        for(String n : my_string.split("")){
            list.add(n);
        }
        
        for (String s : list.stream().distinct().collect(Collectors.toList()))
            answer += s;
        
        // for(int i=0; i<my_string.length(); i++){
        //     if(i==my_string.indexOf(my_string.charAt(i)))
        //         answer+=my_string.charAt(i);
        // }
        
        return answer;
    }
}