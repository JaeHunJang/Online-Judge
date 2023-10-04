import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; ){
            if(stack.isEmpty())
                stack.push(arr[i]);
            else if(stack.peek() == arr[i])
                stack.pop();
            else if(stack.peek() != arr[i])
                stack.push(arr[i]);
            i++;
        }
        
        if(stack.isEmpty()) return new int[]{-1};
        
        answer = new int[stack.size()];
        int j = 0;
        for(int n : stack){
            answer[j++] = n;
        }
        
        return answer;
    }
}