import java.util.*;
class Solution {
    public int[][] solution(int[][] arr) {
        int len = Math.max(arr[0].length, arr.length);
        boolean flag = arr[0].length > arr.length;
        
        int[][] answer = new int[len][len];

        
        if(flag) {
            for(int i = 0; i < arr.length; i++){
                answer[i] = Arrays.copyOf(arr[i], len);
            }
        } else {
            for(int i = 0; i < len; i++){
                answer[i] = Arrays.copyOf(arr[i], len);
            }
        }
        
        return answer;
    }
}