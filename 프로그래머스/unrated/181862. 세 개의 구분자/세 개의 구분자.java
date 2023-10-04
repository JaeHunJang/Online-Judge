import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        ArrayList<String> list = new ArrayList<>();
        
        for(String str_a : myStr.split("a")){
            for(String str_b : str_a.split("b"))
                for(String str_c : str_b.split("c"))
                    if(!str_c.equals(""))
                        list.add(str_c);
        }
        
        return list.size() > 0 ? list.toArray(new String[list.size()]) : new String[]{"EMPTY"};
    }
}