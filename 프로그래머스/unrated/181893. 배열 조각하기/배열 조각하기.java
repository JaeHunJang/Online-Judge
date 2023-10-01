import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        int start = 0;
        int end = arr.length;
        for(int i = 0; i < query.length; i++){
            // if(i % 2 == 0) 
            //     arr = Arrays.copyOfRange(arr, 0, query[i] + 1);
            // else
            //     arr = Arrays.copyOfRange(arr, query[i], arr.length);
            if (i % 2 == 0) {
                end = start + query[i] - 1;
            } else {
                start += query[i];
            }
        }

        return Arrays.copyOfRange(arr, start, end + 2);
    }
}