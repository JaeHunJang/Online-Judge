class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        if (arr1.length == arr2.length) {
            for(int n : arr1)
                answer += n;
            
            for(int n : arr2)
                answer -= n;
            
            if(answer > 0)
                return 1;
            else if(answer < 0)
                return -1;
            else return 0;
        }
        
        if(arr1.length > arr2.length) {
            return 1;
        } else return -1; 
        
    }
}