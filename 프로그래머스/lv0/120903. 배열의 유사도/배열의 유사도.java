class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        for(String ch1 : s1)
            for(String ch2 : s2)
                answer += ch1.equals(ch2) ? 1 : 0;
        
        return answer;
    }
}