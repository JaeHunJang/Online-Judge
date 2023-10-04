class Solution {
    public String solution(String myString) {
        String answer = "";
        
        myString = myString.toLowerCase();
        for(String s : myString.split(""))
            answer += s.equals("a") ? s.toUpperCase() : s;
            
        return answer;
    }
}