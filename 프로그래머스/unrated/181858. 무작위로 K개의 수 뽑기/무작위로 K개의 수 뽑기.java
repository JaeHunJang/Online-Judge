import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        int i = 0;
        List<Integer> list = new ArrayList();
        
        for(int n : arr){
            list.add(n);
        }
        List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
        
        for(; i < k; i++){
            if(i >= newList.size()) { 
                answer[i] = -1;
                continue;
            }
            answer[i] = newList.get(i);
        }
        
        return answer;
    }
}