class Solution {
    public String solution(String myString) {
        String answer = "";
        for(char ch : myString.toCharArray()){
            answer += ch < 'l' ? 'l' : ch;
        }
        return answer;
    }
}