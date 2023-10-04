class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String temp = myString;

        while(temp.contains(pat)){
            temp = temp.substring(temp.indexOf(pat) + 1, temp.length());
            answer++;
        }
        
        return answer;
    }
}