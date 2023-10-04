class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        for(char ch : my_string.toCharArray())
            if(Character.isDigit(ch)) answer += Integer.parseInt(ch + "");
        
        return answer;
    }
}