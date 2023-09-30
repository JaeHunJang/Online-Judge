import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack stack = new Stack();
        
        for(String ch : s.split("")){
            if(!stack.empty() && ch.equals(stack.peek())){
                stack.pop();
            } else { 
                stack.push(ch);
            }
        }
        
        if(stack.empty()) return 1;
        else return 0;
    }
}