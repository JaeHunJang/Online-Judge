import java.util.*;
class Solution {
    public String solution(String my_string) {
        char[] temp = my_string.toLowerCase().toCharArray();
        
        Arrays.sort(temp);
        
        return new StringBuilder().append(temp).toString();
    }
}