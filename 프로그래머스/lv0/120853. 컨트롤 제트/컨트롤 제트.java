class Solution {
    public int solution(String s) {
        int answer = 0;
        int prev = 0;
        for(String ch : s.split(" ")){
            if(!"Z".equals(ch)) {
                prev = Integer.parseInt(ch);
                answer += prev;
            } else {
                answer -= prev;
            }
        }
        
        return answer;
    }
}