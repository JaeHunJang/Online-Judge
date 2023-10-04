class Solution {
    public String solution(String n_str) {
        String answer = "";
        
        boolean flag = n_str.startsWith("0");
        for(int i = 0; i < n_str.length(); i++){
            if(!n_str.substring(i, n_str.length()).startsWith("0")) {
                answer = n_str.substring(i, n_str.length());
                break;
            }
        }
            
        return answer;
    }
}