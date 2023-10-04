class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        
        for (int n : array)
            answer += n > height ? 1 : 0;
            
        return answer;
    }
}