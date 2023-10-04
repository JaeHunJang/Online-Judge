import java.util.*;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> list = new ArrayList<>();
        
        int i = 0;
        for(boolean b : finished){
            if(!b) list.add(todo_list[i]);
            i++;
        }
        
        return list.toArray(new String[list.size()]);
    }
}