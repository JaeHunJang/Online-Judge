import java.util.*;
class Solution {
    private void swap(int x, int y, int[] arr){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] temp = new String[numbers.length];
        for(int i = 0; i < temp.length; i++)
            temp[i] = numbers[i] + "";
       
        Arrays.sort(temp, (o1, o2) -> {
            return Integer.parseInt((o2 + o1 + "")) -  Integer.parseInt((o1 + o2 + ""));
        });
        
        for(String n : temp)
            answer += n;
        
        if(answer.startsWith("0")) return "0";
        
        return answer;
    }
}