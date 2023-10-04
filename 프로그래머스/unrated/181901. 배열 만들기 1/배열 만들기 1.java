class Solution {
    public int[] solution(int n, int k) {
        int[] answer = new int[n/k];
        
        for(int i = 0, j = k; i < answer.length; i++, j += k)
            answer[i] = j;
        
        return answer;
    }
}