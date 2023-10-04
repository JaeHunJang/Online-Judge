import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        int[] temp1 = {};
        int[] temp2 = Arrays.copyOf(arr, arr.length);
        
        while(!Arrays.equals(temp1, temp2)) {
            answer++;
            temp1 = Arrays.copyOf(temp2, temp2.length);
            for(int i = 0; i < temp2.length; i++){
                if(temp2[i] >= 50 && temp2[i] % 2 == 0)
                    temp2[i] /= 2;
                else if(temp2[i] < 50 && temp2[i] % 2 == 1)
                    temp2[i] = temp2[i] * 2 + 1;
            }
        }
        return answer-1;
    }
}