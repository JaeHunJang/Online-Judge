import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        my_string = my_string.replaceAll("\\s+", " ");
        
        ArrayList<String> list = new ArrayList<>();
        
        for(String s : my_string.split(" ")){
            if(!"".equals(s))
                list.add(s);
        }
        
        return list.toArray(new String[list.size()]);
    }
}