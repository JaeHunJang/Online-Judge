import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int i = 1;
        while(i < arr.length)
            i *= 2;
        
        return Arrays.copyOf(arr, i);
    }
}