import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int n : arr){
            boolean flag = true;
            for(int m : delete_list){
                if(n == m) flag = false;
            }
            if(flag) list.add(n);
        }
        
        int[] answer = new int[list.size()];
        int i = 0;
        for(int n : list){
            answer[i++] = n;
        }
        
        return answer;
    }
}