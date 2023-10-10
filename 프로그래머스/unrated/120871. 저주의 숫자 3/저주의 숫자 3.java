class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i = 1; i <= n; i++, answer++){
            while((answer+"").contains("3") || answer % 3 == 0) {
                answer++;
            }
        }
        
        return answer-1;
        
        // for(int i = 1; i <= n; i++){
        //     if((i+"").contains("3") || i % 3 == 0) {
        //         n++;
        //     }
        // }
        // return n;
    }
}