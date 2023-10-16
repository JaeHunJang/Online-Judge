import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] temp = new String[numbers.length];
        for(int i = 0; i < temp.length; i++)
            temp[i] = numbers[i] + "";
       
        Arrays.sort(temp, (o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });
        
        for(String n : temp)
            answer += n;
        
        if(answer.startsWith("0")) return "0"; //0으로 시작한 경우 제공된 배열이 전부 0
        
        return answer;
    }
}