class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i = 1; i <= n; i++, answer++){
            while((answer+"").contains("3") || answer % 3 == 0) {
                answer++;
            }
            System.out.println(answer);
        }
        
        return answer-1;
    }
}