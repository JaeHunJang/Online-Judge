class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        
        for(String s : my_string.split("")){
            answer += s.equals(letter) ? "" : s;
        }
        
        
        return answer;
    }
}