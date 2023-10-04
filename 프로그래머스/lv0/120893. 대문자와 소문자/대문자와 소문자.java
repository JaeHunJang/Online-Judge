class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for(char ch : my_string.toCharArray()){
            answer += Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
        }
        
        return answer;
    }
}