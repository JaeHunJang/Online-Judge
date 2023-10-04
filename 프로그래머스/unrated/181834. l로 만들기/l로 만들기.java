class Solution {
    public String solution(String myString) {
        // String answer = "";
        // for(char ch : myString.toCharArray()){
        //     answer += ch < 'l' ? 'l' : ch;
        // }
        // return answer;
        return myString.replaceAll("[^l-z]", "l");
    }
}