class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        for(int n : num_list) {
            if(n < 0)
                break;
            answer++;
        }
        
        return answer == num_list.length ? -1 : answer;
    }
}