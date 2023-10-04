class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        
        for(int num : numbers){
            answer += answer <= n ? num : 0;
        }
        
        return answer;
    }
}