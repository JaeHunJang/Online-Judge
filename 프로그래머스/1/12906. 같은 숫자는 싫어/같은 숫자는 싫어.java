import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int a : arr) {
            if (stack.isEmpty() || stack.peek() != a) {
                stack.push(a);
            }
        }

        int[] answer = new int[stack.size()];
        while(!stack.isEmpty()) answer[stack.size()-1] = stack.pop();
        
        return answer;
    }
}