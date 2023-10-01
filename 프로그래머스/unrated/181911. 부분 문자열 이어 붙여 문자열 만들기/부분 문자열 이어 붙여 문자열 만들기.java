class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        int idx = 0;
        for(String s : my_strings){
            answer += s.substring(parts[idx][0], parts[idx++][1]+1);
        }
        
        return answer;
    }
}