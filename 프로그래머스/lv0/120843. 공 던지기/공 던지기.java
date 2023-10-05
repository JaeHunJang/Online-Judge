class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        for(int i = 0, j = 0; i < k; i++, j+=2){
            answer = numbers[j % numbers.length];
        }
        
        return answer;
    }
}