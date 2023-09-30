class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 0, j = 1;
        int cnt = 0;
        
        while(cnt+1 < n){
            answer = (i + j) % 1234567;
            cnt++;
            i = j;
            j = answer;
            
        }
        
        return answer;
    }
}