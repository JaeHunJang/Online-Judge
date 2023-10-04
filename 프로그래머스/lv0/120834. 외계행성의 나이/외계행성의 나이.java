class Solution {
    public String solution(int age) {
        String answer = "";
        
        for(char ch : (age+"").toCharArray()){
            answer += (char)((int)ch - 48 + 97);
        }
        
        return answer;
    }
}