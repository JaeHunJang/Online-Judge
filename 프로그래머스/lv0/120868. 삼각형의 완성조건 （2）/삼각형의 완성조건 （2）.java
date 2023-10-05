class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int i = 1;
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        
        for(; i < max; i++){
            if (min + i > max)
                answer++;
        }
        for(; min + max > i; i++){
            answer++;
        }
        
        return answer;
    }
}