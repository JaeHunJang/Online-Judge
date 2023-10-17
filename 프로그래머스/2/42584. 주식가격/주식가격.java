import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                answer[i]++;
                if(prices[i] > prices[j]) { 
                    break;
                }
            }
        }
        
        return answer;
        
        /* Stack을 이용한 풀이
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int[] terms = new int[prices.length]; //정답 배열

        stack.push(i);
        for (i = 1; i < prices.length; i++) {
            while (!stack.empty() && prices[stack.peek()] > prices[i]) { //하락장일때 계산
                int beginIdx = stack.pop();
                terms[beginIdx] = i - beginIdx;
            }
            stack.push(i);
        }
        while (!stack.empty()) { //나머지 상승장일때 계산
            int beginIdx = stack.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
        */
    }
}