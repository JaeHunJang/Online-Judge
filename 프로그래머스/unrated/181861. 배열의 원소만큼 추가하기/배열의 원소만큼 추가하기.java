class Solution {
    public int[] solution(int[] arr) {
        int len = 0;
        
        for(int n : arr){
            len += n;
        }
        
        int[] answer = new int[len];
        
        len = 0;
        for(int n : arr){
            for(int i = 0; i < n; i++)
                answer[len++] = n;
        }
        
        return answer;
    }
}