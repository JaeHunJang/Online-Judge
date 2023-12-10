import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<String> stack = new Stack();
        for(String n : number.split("")) {
            while(!stack.isEmpty() && stack.peek().compareTo(n) < 0 && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(n);
        }
        
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        return String.join("", stack);
        
// /*시간 초과*/
//         if(k == 0) return number;
        
//         StringBuilder sb = new StringBuilder();
//         for(int i = 0; i < number.length(); i++) {
//             if(sb.append(number).deleteCharAt(i).toString().compareTo(answer) > 0)  {
//                 answer = sb.toString();
//                 System.out.println(answer);
//             }
//             sb.setLength(0);
//         }
        
//         return solution(answer, k-1);
    }
}