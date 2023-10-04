class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        for(String s : rsp.split("")){
            if("2".equals(s)) answer += "0";
            else if("0".equals(s)) answer += "5";
            else answer += "2";
        }
        
        return answer;
    }
}