class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        for(String s : my_string.split("[a-zA-Z]")){
            if(!"".equals(s)) answer += Integer.parseInt(s);
        }

        return answer;
    }
}