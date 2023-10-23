import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String open = "({[";
        String close = ")}]";
        
        for(int i = 0; i < s.length(); i++){
            Stack<String> stack = new Stack();
            String temp = s.substring(i, s.length()) + s.substring(0, i); 
            for(String t : temp.split("")){
                if(close.contains(t)) {
                    int idx = close.indexOf(t);
                    if(!stack.isEmpty() && stack.peek().equals(open.charAt(idx) + "")) {
                        stack.pop();
                    } else 
                        stack.push(t);
                } else 
                    stack.push(t);
            }
            if (stack.isEmpty()) 
                answer++;
        }
        return answer;
    }
}