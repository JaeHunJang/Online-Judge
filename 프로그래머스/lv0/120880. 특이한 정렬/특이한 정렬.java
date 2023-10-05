import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        
        String[] temp = new String[numlist.length];
        int i = 0;
        for(int num : numlist)
            temp[i++] = num+"";
        
        Arrays.sort(temp, new Comparator<String>(){
           public int compare(String o1, String o2){
               int num1 = Integer.parseInt(o1);
               int num2 = Integer.parseInt(o2);
               if(Math.abs(n - num1) == Math.abs(n - num2))
                   return num2 - num1;
               else
                   return Math.abs(n - num1) - Math.abs(n - num2);
           }
        });
        
        i = 0;
        for(String num : temp)
            answer[i++] = Integer.parseInt(num);
        
        return answer;
    }
}