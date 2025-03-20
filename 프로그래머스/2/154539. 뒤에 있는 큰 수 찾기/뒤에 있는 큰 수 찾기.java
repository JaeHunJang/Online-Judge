import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> big = new Stack<>();
        for (int i = numbers.length-1; i >= 0; --i) {
            if (big.isEmpty()) {
                answer[i] = -1;
            } else {
                while(!big.isEmpty()) {
                    if (big.peek() > numbers[i]) {
                        answer[i] = big.peek();
                        break;
                    } else {
                        big.pop();
                    }
                }
                if (big.isEmpty()) {
                    answer[i] = -1;
                } 
            }
            big.push(numbers[i]);
        }
        
        return answer;
    }
}