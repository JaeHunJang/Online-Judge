import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        StringBuilder sb = new StringBuilder();
        
        for(int n : arr){
            sb.append(n % 10);
        }
        
        if(sb.toString().indexOf("2") < 0 && sb.toString().lastIndexOf("2") < 0)
            return new int[]{-1};
        
        return Arrays.copyOfRange(arr, sb.toString().indexOf("2"), sb.toString().lastIndexOf("2")+1);
    }
}