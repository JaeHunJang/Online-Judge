class Solution {
    public String solution(String my_string, int k) {
        String answer = "";
        
        //for(int i = 0; i < k ; i++)
        //    answer = answer.concat(my_string);
        answer = my_string.repeat(k);
        
        return answer;
    }
}