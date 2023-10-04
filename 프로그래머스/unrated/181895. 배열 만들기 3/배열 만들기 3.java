import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int[] interval : intervals){
            for(int i = interval[0]; i <= interval[1]; i++){
                list.add(arr[i]);
            }
        }
        
        int[] answer = new int[list.size()];
        int i = 0;
        for(int n : list)
            answer[i++] = n;
        
        return answer;
    }
}