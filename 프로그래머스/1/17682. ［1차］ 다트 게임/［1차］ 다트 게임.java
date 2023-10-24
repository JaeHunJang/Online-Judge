import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String score = "SDT";
        String option = "*#";
        String num = "";
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i < dartResult.length(); i++){
            char ch = dartResult.charAt(i);
            if(Character.isDigit(ch)){
                num += ch + "";
            } else {
                if(!num.equals("")) {
                    stack.push((int)Math.pow(Integer.parseInt(num), score.indexOf(ch+"") + 1));
                    num = "";
                }
                if(option.indexOf(ch+"") == 0) {
                    int temp = stack.pop() * 2;
                    System.out.println(temp+"");
                    if(!stack.isEmpty())
                        stack.push(stack.pop() * 2);
                    stack.push(temp);
                } else if (option.indexOf(ch+"") == 1) {
                    stack.push(stack.pop() * -1);
                }
            }
        }
        
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        
        return answer;
    }
}