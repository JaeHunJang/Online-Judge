import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        
        Arrays.sort(indices);
        
        int i = 0;
        for(int idx : indices){
            sb.deleteCharAt(idx-i++);
        }
        
        return sb.toString();
    }
}